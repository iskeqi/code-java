package com.keqi.apihu.pj.service.impl;

import com.keqi.apihu.pj.domain.PjDatasourceTableDO;
import com.keqi.apihu.pj.mapper.PjDatasourceTableMapper;
import com.keqi.apihu.pj.service.PjDatasourceTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PjDatasourceTableServiceImpl implements PjDatasourceTableService{

    @Resource
    private PjDatasourceTableMapper pjDatasourceTableMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pjDatasourceTableMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PjDatasourceTableDO record) {
        return pjDatasourceTableMapper.insert(record);
    }

    @Override
    public int insertSelective(PjDatasourceTableDO record) {
        return pjDatasourceTableMapper.insertSelective(record);
    }

    @Override
    public PjDatasourceTableDO selectByPrimaryKey(Long id) {
        return pjDatasourceTableMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PjDatasourceTableDO record) {
        return pjDatasourceTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PjDatasourceTableDO record) {
        return pjDatasourceTableMapper.updateByPrimaryKey(record);
    }

    @Override
    public void deleteByDatasourceId(Long datasourceId) {

    }

    @Override
    public void insertList(List<PjDatasourceTableDO> datasourceTableDOList) {
        this.pjDatasourceTableMapper.insertList(datasourceTableDOList);
    }
}
