package com.keqi.seed.sys.service;

import com.keqi.seed.sys.domain.param.MenuParam;

import java.util.Map;

public interface MenuService {

	Map<String, Long> insert(MenuParam param);

	void updateById(MenuParam param);

	void deleteById(Long id);
}