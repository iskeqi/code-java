package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.RolePageParam;
import com.keqi.knife4j.sys.domain.param.RoleParam;
import com.keqi.knife4j.sys.domain.vo.RoleVO;

public interface RoleService {

	/**
	 * 新增角色
	 *
	 * @param param param
	 */
	void insert(RoleParam param);

	/**
	 * 修改角色
	 *
	 * @param param param
	 */
	void updateById(RoleParam param);

	/**
	 * 根据ID删除角色
	 *
	 * @param id id
	 */
	void deleteById(Long id);

	/**
	 * 分页查询角色列表
	 *
	 * @param param param
	 * @return r
	 */
	PageVO<RoleVO> page(RolePageParam param);
}