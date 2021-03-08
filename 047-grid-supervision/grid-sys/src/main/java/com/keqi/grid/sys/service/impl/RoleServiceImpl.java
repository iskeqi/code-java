package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.RoleDO;
import com.keqi.grid.sys.domain.param.RolePageParam;
import com.keqi.grid.sys.domain.param.RoleParam;
import com.keqi.grid.sys.domain.vo.RoleVO;
import com.keqi.grid.sys.mapper.RoleMapper;
import com.keqi.grid.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	@Transactional
	public void insert(RoleParam param) {
		RoleDO t = BeanUtil.copyProperties(param, RoleDO.class);
		this.roleMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(RoleParam param) {
		RoleDO t = BeanUtil.copyProperties(param, RoleDO.class);
		this.roleMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.roleMapper.deleteById(id);
	}

	@Override
	public PageVO<RoleVO> page(RolePageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		// List<RoleVO> result = this.roleMapper.page(param);

		// return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
		return null;
	}
}
