package com.keqi.grid.sys.service;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.AccountRolePageParam;
import com.keqi.grid.sys.domain.param.AccountRoleParam;
import com.keqi.grid.sys.domain.vo.AccountRoleVO;

public interface AccountRoleService {

	void insert(AccountRoleParam param);

	void updateById(AccountRoleParam param);

	void deleteById(Long id);

	PageVO<AccountRoleVO> page(AccountRolePageParam param);
}