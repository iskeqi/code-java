package com.keqi.grid.sys.service;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.MenuPageParam;
import com.keqi.grid.sys.domain.param.MenuParam;
import com.keqi.grid.sys.domain.vo.MenuVO;

public interface MenuService {

	void insert(MenuParam param);

	void updateById(MenuParam param);

	void deleteById(Long id);

	PageVO<MenuVO> page(MenuPageParam param);
}