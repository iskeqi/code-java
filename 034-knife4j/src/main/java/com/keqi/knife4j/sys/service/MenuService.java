package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.MenuPageParam;
import com.keqi.knife4j.sys.domain.param.MenuParam;
import com.keqi.knife4j.sys.domain.vo.MenuVO;

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

	/**
	 * 分页查询菜单列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	PageVO<MenuVO> page(MenuPageParam pageParam);
}