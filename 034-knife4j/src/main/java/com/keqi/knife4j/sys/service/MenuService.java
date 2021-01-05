package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.sys.domain.param.MenuParam;

public interface MenuService {

	/**
	 * 新增菜单
	 *
	 * @param menuParam menuParam
	 */
	void insert(MenuParam menuParam);

	/**
	 * 根据ID修改菜单
	 *
	 * @param menuParam menuParam
	 */
	void updateById(MenuParam menuParam);

	/**
	 * 根据ID删除菜单
	 *
	 * @param id id
	 */
	void deleteById(Long id);

}