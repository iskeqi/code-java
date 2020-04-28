package com.keqi.apihu.pj.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.keqi.apihu.pj.PjConstant;
import com.keqi.apihu.pj.domain.PjApiGroupDO;
import com.keqi.apihu.pj.mapper.PjApiGroupMapper;
import com.keqi.apihu.pj.service.PjApiGroupService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@ConditionalOnBean
public class PjApiGroupServiceImpl implements PjApiGroupService {

	private final PjApiGroupMapper pjApiGroupMapper;

	@Override
	public void deleteByPrimaryKey(Long id) {
		// 如果该分组及其子分组下都没有API接口，才允许删除
		List<PjApiGroupDO> pjApiGroupDOList = this.pjApiGroupMapper.listChildById(id);
		pjApiGroupDOList.add(new PjApiGroupDO(id));

		// 查询指定分组ID下的API总数

		// 删除所有的子分组
		List<Long> idList = pjApiGroupDOList.stream().map(PjApiGroupDO::getId).collect(Collectors.toList());
		if (CollUtil.isNotEmpty(idList)) {
			this.pjApiGroupMapper.deleteByIds(idList);
		}
	}

	@Override
	@Transactional
	public int create(PjApiGroupDO record) {
		return this.pjApiGroupMapper.insert(record);
	}

	@Override
	public int insertSelective(PjApiGroupDO record) {
		return pjApiGroupMapper.insertSelective(record);
	}

	@Override
	public PjApiGroupDO selectByPrimaryKey(Long id) {
		return pjApiGroupMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PjApiGroupDO record) {
		return pjApiGroupMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updateNameByPrimaryKey(PjApiGroupDO record) {
		pjApiGroupMapper.updateNameByPrimaryKey(record);
	}

	@Override
	public List<PjApiGroupDO> list() {
		return this.buildTree(this.pjApiGroupMapper.listAll(), PjConstant.topLevelID);
	}

	@Override
	@Transactional
	public void moveGroupOrder(List<PjApiGroupDO> pjApiGroupDOList) {
		this.pjApiGroupMapper.moveGroupOrder(pjApiGroupDOList);
	}

	//================私有方法================//

	private List<PjApiGroupDO> buildTree(List<PjApiGroupDO> pjApiGroupDOList, long topLevelID) {
		List<PjApiGroupDO> list = new ArrayList<>();
		for (PjApiGroupDO pjApiGroupDO : pjApiGroupDOList) {
			if (pjApiGroupDO.getParentId() == topLevelID) {
				pjApiGroupDO.setSubPjApiGroupDOList(buildTree(pjApiGroupDOList, pjApiGroupDO.getId()));
				list.add(pjApiGroupDO);
			}
		}
		list.sort(Comparator.comparing(PjApiGroupDO::getOrderNum));
		return list;
	}
}
