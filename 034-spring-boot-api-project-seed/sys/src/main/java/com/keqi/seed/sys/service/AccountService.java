package com.keqi.seed.sys.service;

import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.param.AccountPageParam;
import com.keqi.seed.sys.domain.param.AccountParam;
import com.keqi.seed.sys.domain.param.LoginParam;
import com.keqi.seed.sys.domain.vo.AccountDetailVO;
import com.keqi.seed.sys.domain.vo.AccountVO;
import com.keqi.seed.sys.domain.vo.LoginVO;

public interface AccountService {

	void insert(AccountParam param);

	void updateById(AccountParam param);

	void deleteById(Long id);

	PageVO<AccountVO> page(AccountPageParam param);

	LoginVO login(LoginParam param);

	void updatePassword(String password, String newPassword);

	AccountDetailVO selectLoginUserInfo();
}
