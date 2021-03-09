package com.keqi.grid.sys.service;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.LoginAccountPageParam;
import com.keqi.grid.sys.domain.param.LoginAccountParam;
import com.keqi.grid.sys.domain.vo.LoginAccountVO;

public interface LoginAccountService {

	void insert(LoginAccountParam param);

	void updateById(LoginAccountParam param);

	void deleteById(Long id);

	PageVO<LoginAccountVO> page(LoginAccountPageParam param);
}