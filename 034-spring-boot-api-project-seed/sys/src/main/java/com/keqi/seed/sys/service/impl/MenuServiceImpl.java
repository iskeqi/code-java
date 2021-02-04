package com.keqi.seed.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.seed.sys.domain.db.MenuDO;
import com.keqi.seed.sys.domain.param.MenuParam;
import com.keqi.seed.sys.mapper.MenuMapper;
import com.keqi.seed.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	@Transactional
	public Map<String, Long> insert(MenuParam param) {
		MenuDO t = BeanUtil.copyProperties(param, MenuDO.class);
		this.menuMapper.insert(t);

		Map<String, Long> r = new HashMap<>();
		r.put("id", t.getId());
		return r;
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
}
