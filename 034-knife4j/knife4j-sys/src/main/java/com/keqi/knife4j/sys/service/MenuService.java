package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.sys.domain.param.MenuParam;
import com.keqi.knife4j.sys.domain.vo.MenuVO;

import java.util.List;

public interface MenuService {

	void insert(MenuParam param);

	void updateById(MenuParam param);

	void deleteById(Long id);

	/**
	 * 根据 accountId 查询用户拥有的菜单列表
	 *
	 * @param accountId accountId
	 * @return r
	 */
	List<MenuVO> queryTheCurrentUserMenuList(Long accountId);
}