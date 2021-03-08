package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.MenuDO;
import com.keqi.grid.sys.domain.param.MenuPageParam;
import com.keqi.grid.sys.domain.param.MenuParam;
import com.keqi.grid.sys.domain.vo.MenuVO;
import com.keqi.grid.sys.mapper.MenuMapper;
import com.keqi.grid.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	@Transactional
	public void insert(MenuParam param) {
		MenuDO t = BeanUtil.copyProperties(param, MenuDO.class);
		this.menuMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(MenuParam param) {
		MenuDO t = BeanUtil.copyProperties(param, MenuDO.class);
		this.menuMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.menuMapper.deleteById(id);
	}

	@Override
	public PageVO<MenuVO> page(MenuPageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		// List<MenuVO> result = this.menuMapper.page(param);

		// return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
		return null;
	}
}
