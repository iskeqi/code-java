package com.keqi.knife4j.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.knife4j.sys.domain.db.MenuDO;
import com.keqi.knife4j.sys.domain.param.MenuParam;
import com.keqi.knife4j.sys.mapper.MenuMapper;
import com.keqi.knife4j.sys.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

	private final MenuMapper menuMapper;

	/**
	 * 新增菜单
	 *
	 * @param menuParam menuParam
	 */
	@Override
	@Transactional
	public void insert(MenuParam menuParam) {
		MenuDO t = new MenuDO();
		BeanUtil.copyProperties(menuParam, t);

		this.menuMapper.insert(t);
	}

	/**
	 * 根据ID修改菜单
	 *
	 * @param menuParam menuParam
	 */
	@Override
	@Transactional
	public void updateById(MenuParam menuParam) {
		MenuDO t = new MenuDO();
		BeanUtil.copyProperties(menuParam, t);

		this.menuMapper.updateById(t);
	}

	/**
	 * 根据ID删除菜单
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {
		this.menuMapper.deleteById(id);
	}

}
