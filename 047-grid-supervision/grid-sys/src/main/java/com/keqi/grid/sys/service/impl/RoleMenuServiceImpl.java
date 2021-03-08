package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.RoleMenuDO;
import com.keqi.grid.sys.domain.param.RoleMenuPageParam;
import com.keqi.grid.sys.domain.param.RoleMenuParam;
import com.keqi.grid.sys.domain.vo.RoleMenuVO;
import com.keqi.grid.sys.mapper.RoleMenuMapper;
import com.keqi.grid.sys.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Override
	@Transactional
	public void insert(RoleMenuParam param) {
		RoleMenuDO t = BeanUtil.copyProperties(param, RoleMenuDO.class);
		this.roleMenuMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(RoleMenuParam param) {
		RoleMenuDO t = BeanUtil.copyProperties(param, RoleMenuDO.class);
		this.roleMenuMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.roleMenuMapper.deleteById(id);
	}

	@Override
	public PageVO<RoleMenuVO> page(RoleMenuPageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		// List<RoleMenuVO> result = this.roleMenuMapper.page(param);

		// return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
		return null;
	}
}
