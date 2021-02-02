package com.keqi.seed.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.RoleDO;
import com.keqi.seed.sys.domain.db.RoleMenuDO;
import com.keqi.seed.sys.domain.param.RolePageParam;
import com.keqi.seed.sys.domain.param.RoleParam;
import com.keqi.seed.sys.domain.vo.RoleVO;
import com.keqi.seed.sys.mapper.RoleMapper;
import com.keqi.seed.sys.mapper.RoleMenuMapper;
import com.keqi.seed.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Override
	@Transactional
	public void insert(RoleParam param) {
		RoleDO roleDO = BeanUtil.copyProperties(param, RoleDO.class);
		this.roleMapper.insert(roleDO);

		List<Long> menuIdList = param.getMenuIdList();
		if (CollUtil.isNotEmpty(menuIdList)) {
			List<RoleMenuDO> list = new ArrayList<>();
			for (Long menuId : menuIdList) {
				RoleMenuDO t = new RoleMenuDO();
				t.setMenuId(menuId);
				t.setRoleId(param.getId());
				list.add(t);
			}
			this.roleMenuMapper.insertList(list);
		}
	}

	@Override
	@Transactional
	public void updateById(RoleParam param) {
		RoleDO roleDO = BeanUtil.copyProperties(param, RoleDO.class);

		this.roleMapper.updateById(roleDO);
		List<Long> menuIdList = param.getMenuIdList();
		if (CollUtil.isNotEmpty(menuIdList)) {
			this.roleMenuMapper.deleteByRoleId(param.getId());

			List<RoleMenuDO> list = new ArrayList<>();
			for (Long menuId : menuIdList) {
				RoleMenuDO t = new RoleMenuDO();
				t.setMenuId(menuId);
				t.setRoleId(param.getId());
				list.add(t);
			}
			this.roleMenuMapper.insertList(list);
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.roleMenuMapper.deleteByRoleId(id);
		this.roleMapper.deleteById(id);
	}

	@Override
	public PageVO<RoleVO> page(RolePageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<RoleVO> result = this.roleMapper.page(param);

		return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
	}
}
