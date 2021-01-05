package com.keqi.knife4j.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.RolePageParam;
import com.keqi.knife4j.sys.domain.param.RoleParam;
import com.keqi.knife4j.sys.domain.vo.RoleVO;
import com.keqi.knife4j.sys.mapper.RoleMapper;
import com.keqi.knife4j.sys.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

	private final RoleMapper roleMapper;

	/**
	 * 新增角色
	 *
	 * @param roleParam roleParam
	 */
	@Override
	@Transactional
	public void insert(RoleParam roleParam) {

	}

	/**
	 * 根据ID修改角色
	 *
	 * @param roleParam roleParam
	 */
	@Override
	@Transactional
	public void updateById(RoleParam roleParam) {

	}

	/**
	 * 根据ID删除角色
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {

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
