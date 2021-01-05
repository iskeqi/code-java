package com.keqi.knife4j.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.db.RoleDO;
import com.keqi.knife4j.sys.domain.db.RoleMenuDO;
import com.keqi.knife4j.sys.domain.param.RolePageParam;
import com.keqi.knife4j.sys.domain.param.RoleParam;
import com.keqi.knife4j.sys.domain.vo.RoleVO;
import com.keqi.knife4j.sys.mapper.RoleMapper;
import com.keqi.knife4j.sys.mapper.RoleMenuMapper;
import com.keqi.knife4j.sys.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

	private final RoleMapper roleMapper;
	private final RoleMenuMapper roleMenuMapper;

	/**
	 * 新增角色
	 *
	 * @param roleParam roleParam
	 */
	@Override
	@Transactional
	public void insert(RoleParam roleParam) {
		RoleDO roleDO = new RoleDO();
		BeanUtil.copyProperties(roleParam, roleDO);
		this.roleMapper.insert(roleDO);

		// 新增角色-菜单关联记录
		List<Long> menuIdList = roleParam.getMenuIdList();
		if (CollUtil.isNotEmpty(menuIdList)) {
			List<RoleMenuDO> list = new ArrayList<>();
			for (Long menuId : menuIdList) {
				RoleMenuDO t = new RoleMenuDO();
				t.setMenuId(menuId);
				t.setRoleId(roleParam.getId());
				list.add(t);
			}
			this.roleMenuMapper.insertList(list);
		}
	}

	/**
	 * 根据ID修改角色
	 *
	 * @param roleParam roleParam
	 */
	@Override
	@Transactional
	public void updateById(RoleParam roleParam) {
		RoleDO roleDO = new RoleDO();
		BeanUtil.copyProperties(roleParam, roleDO);
		this.roleMapper.updateById(roleDO);

		// 新增角色-菜单关联记录
		List<Long> menuIdList = roleParam.getMenuIdList();
		if (CollUtil.isNotEmpty(menuIdList)) {
			this.roleMenuMapper.deleteByRoleId(roleParam.getId());

			List<RoleMenuDO> list = new ArrayList<>();
			for (Long menuId : menuIdList) {
				RoleMenuDO t = new RoleMenuDO();
				t.setMenuId(menuId);
				t.setRoleId(roleParam.getId());
				list.add(t);
			}
			this.roleMenuMapper.insertList(list);
		}
	}

	/**
	 * 根据ID删除角色
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {
		this.roleMenuMapper.deleteByRoleId(id);
		this.roleMapper.deleteById(id);
	}

	/**
	 * 分页查询角色列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	@Override
	public PageVO<RoleVO> page(RolePageParam pageParam) {
		Page<RoleVO> page = new Page<>(pageParam.getCurrent(), pageParam.getSize());
		IPage<RoleVO> result = this.roleMapper.page(page, pageParam);

		return new PageVO<>(result.getTotal(), result.getRecords());
	}
}
