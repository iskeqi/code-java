package com.keqi.knife4j.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.knife4j.sys.domain.db.MenuDO;
import com.keqi.knife4j.sys.domain.param.MenuParam;
import com.keqi.knife4j.sys.domain.vo.MenuVO;
import com.keqi.knife4j.sys.mapper.MenuMapper;
import com.keqi.knife4j.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	/**
	 * 新增菜单
	 *
	 * @param param param
	 */
	@Override
	@Transactional
	public void insert(MenuParam param) {
		MenuDO t = new MenuDO();
		BeanUtil.copyProperties(param, t);

		this.menuMapper.insert(t);
	}

	/**
	 * 修改菜单
	 *
	 * @param param param
	 */
	@Override
	@Transactional
	public void updateById(MenuParam param) {
		MenuDO t = new MenuDO();
		BeanUtil.copyProperties(param, t);

		this.menuMapper.updateById(t);
	}

	/**
	 * 删除菜单
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {
		this.menuMapper.deleteById(id);
	}

	/**
	 * 根据 accountId 查询用户拥有的菜单列表
	 *
	 * @param accountId accountId
	 * @return r
	 */
	@Override
	public List<MenuVO> queryTheCurrentUserMenuList(Long accountId) {
		return this.assembleTreeList(this.menuMapper.listByAccountId(accountId), 0L);
	}

	/**
	 * 把没有层次结构的菜单列表按照父子结构关系进行组装（递归构造树形结构）
	 *
	 * @param menuVOList menuVOList
	 * @return r
	 */
	private List<MenuVO> assembleTreeList(List<MenuVO> menuVOList, Long rootParentId) {
		List<MenuVO> menuVOTreeList = new ArrayList<>();
		for (MenuVO vo : menuVOList) {
			if (vo.getParentId().equals(rootParentId)) {
				vo.setMenuList(assembleTreeList(menuVOList, vo.getId()));
				menuVOTreeList.add(vo);
			}
		}
		menuVOTreeList.sort(Comparator.comparing(MenuVO::getOrderNum));
		return menuVOTreeList;
	}

}
