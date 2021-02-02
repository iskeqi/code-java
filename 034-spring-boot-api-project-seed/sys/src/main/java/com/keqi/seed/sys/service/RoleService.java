package com.keqi.seed.sys.service;

import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.param.RolePageParam;
import com.keqi.seed.sys.domain.param.RoleParam;
import com.keqi.seed.sys.domain.vo.RoleVO;

public interface RoleService {

	void insert(RoleParam param);

	void updateById(RoleParam param);

	void deleteById(Long id);

	PageVO<RoleVO> page(RolePageParam param);
}