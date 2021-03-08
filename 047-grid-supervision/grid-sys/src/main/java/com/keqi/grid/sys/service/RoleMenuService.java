package com.keqi.grid.sys.service;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.RoleMenuPageParam;
import com.keqi.grid.sys.domain.param.RoleMenuParam;
import com.keqi.grid.sys.domain.vo.RoleMenuVO;

public interface RoleMenuService {

	void insert(RoleMenuParam param);

	void updateById(RoleMenuParam param);

	void deleteById(Long id);

	PageVO<RoleMenuVO> page(RoleMenuPageParam param);
}