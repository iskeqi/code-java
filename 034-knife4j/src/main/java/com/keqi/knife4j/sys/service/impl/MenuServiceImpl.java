package com.keqi.knife4j.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.MenuPageParam;
import com.keqi.knife4j.sys.domain.param.MenuParam;
import com.keqi.knife4j.sys.domain.vo.MenuVO;
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

	}

	/**
	 * 根据ID修改菜单
	 *
	 * @param menuParam menuParam
	 */
	@Override
	@Transactional
	public void updateById(MenuParam menuParam) {

	}

	/**
	 * 根据ID删除菜单
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {

	}

	/**
	 * 分页查询菜单列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	@Override
	public PageVO<MenuVO> page(MenuPageParam pageParam) {
		Page<MenuVO> page = new Page<>(pageParam.getCurrent(), pageParam.getSize());
		IPage<MenuVO> result = this.menuMapper.page(page, pageParam);

		return new PageVO<>(result.getTotal(), result.getRecords());
	}
}
