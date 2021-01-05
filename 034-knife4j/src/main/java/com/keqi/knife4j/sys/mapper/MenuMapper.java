package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.MenuDO;
import com.keqi.knife4j.sys.domain.vo.MenuVO;

import java.util.List;

public interface MenuMapper extends BaseMapper<MenuDO> {

	/**
	 * 查询指定 accountId 拥有的菜单列表
	 *
	 * @param accountId accountId
	 * @return r
	 */
	List<MenuVO> listByAccountId(Long accountId);
}