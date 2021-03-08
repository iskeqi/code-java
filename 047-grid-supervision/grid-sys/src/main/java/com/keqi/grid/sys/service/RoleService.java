package com.keqi.grid.sys.service;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.RolePageParam;
import com.keqi.grid.sys.domain.param.RoleParam;
import com.keqi.grid.sys.domain.vo.RoleVO;

public interface RoleService {

	void insert(RoleParam param);

	void updateById(RoleParam param);

	void deleteById(Long id);

	PageVO<RoleVO> page(RolePageParam param);
}