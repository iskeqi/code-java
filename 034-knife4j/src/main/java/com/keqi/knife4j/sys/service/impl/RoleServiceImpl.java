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

	/**
	 * 新增角色
	 *
	 * @param param param
	 */
	@Override
	@Transactional
	public void insert(RoleParam param) {
		RoleDO roleDO = BeanUtil.copyProperties(param, RoleDO.class);

		this.roleMapper.insert(roleDO);

		// 新增角色-菜单关联记录
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

	/**
	 * 修改角色
	 *
	 * @param param param
	 */
	@Override
	@Transactional
	public void updateById(RoleParam param) {
		RoleDO roleDO = BeanUtil.copyProperties(param, RoleDO.class);

		this.roleMapper.updateById(roleDO);

		// 新增角色-菜单关联记录
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

	/**
	 * 删除角色
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
	 * @param param param
	 * @return r
	 */
	@Override
	public PageVO<RoleVO> page(RolePageParam param) {
		Page<RoleVO> page = new Page<>(param.getCurrent(), param.getSize());
		IPage<RoleVO> result = this.roleMapper.page(page, param);

		return new PageVO<>(result.getTotal(), result.getRecords());
	}
}
