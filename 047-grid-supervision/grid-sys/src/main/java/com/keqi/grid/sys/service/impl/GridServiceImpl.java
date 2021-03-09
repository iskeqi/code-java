package com.keqi.grid.sys.service.impl;

import com.keqi.grid.sys.domain.db.GridAccountDO;
import com.keqi.grid.sys.domain.db.GridDO;
import com.keqi.grid.sys.domain.vo.GridVO;
import com.keqi.grid.sys.mapper.GridAccountMapper;
import com.keqi.grid.sys.mapper.GridMapper;
import com.keqi.grid.sys.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GridServiceImpl implements GridService {

    @Autowired
    private GridMapper gridMapper;
    @Autowired
    private GridAccountMapper gridAccountMapper;

    @Override
    public List<GridVO> findTreeAll() {
        List<GridDO> gridDOList = this.gridMapper.findAll();
        List<GridVO> gridVOList = new ArrayList<>(gridDOList.size());

        gridDOList.forEach(x -> gridVOList.add(new GridVO(x.getId(), x.getName(), x.getArea(), x.getOrderNum(), x.getParentId())));
        return this.buildTree(gridVOList, 0);
    }

    /**
     * 查询指定用户本级及其子级的网格 id
     *
     * @param accountId
     * @return
     */
    @Override
    public List<Long> findGridIdsByUserId(Long accountId) {
        List<GridAccountDO> list = this.gridAccountMapper.findList(new GridAccountDO(accountId));
        List<Long> gridIds = list.stream().map(GridAccountDO::getGridId).collect(Collectors.toList());

        List<GridDO> subList = this.gridMapper.findSubListByIds(gridIds);
        return subList.stream().map(GridDO::getId).collect(Collectors.toList());
    }

    @Override
    public boolean whetherTheBottomGrid(Long gridId) {
        return this.gridMapper.countByParentId(gridId) == 0;
    }

    private List<GridVO> buildTree(List<GridVO> gridVOList, long rootId) {
        List<GridVO> r = new ArrayList<>();
        for (GridVO t : gridVOList) {
            if (t.getParentId() == rootId) {
                t.setSubList(buildTree(gridVOList, t.getId()));
                r.add(t);
            }
        }
        r.sort(Comparator.comparing(GridVO::getOrderNum));
        return r;
    }
}
