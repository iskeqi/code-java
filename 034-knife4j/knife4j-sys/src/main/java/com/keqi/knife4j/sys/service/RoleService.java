package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.RolePageParam;
import com.keqi.knife4j.sys.domain.param.RoleParam;
import com.keqi.knife4j.sys.domain.vo.RoleVO;

public interface RoleService {

	void insert(RoleParam param);

	void updateById(RoleParam param);

	void deleteById(Long id);

	PageVO<RoleVO> page(RolePageParam param);
}