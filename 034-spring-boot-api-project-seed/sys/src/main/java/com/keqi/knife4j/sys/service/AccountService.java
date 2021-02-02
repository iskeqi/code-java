package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.AccountPageParam;
import com.keqi.knife4j.sys.domain.param.AccountParam;
import com.keqi.knife4j.sys.domain.vo.AccountDetailVO;
import com.keqi.knife4j.sys.domain.vo.AccountVO;
import com.keqi.knife4j.sys.domain.vo.LoginVO;

public interface AccountService {

	void insert(AccountParam param);

	void updateById(AccountParam param);

	void deleteById(Long id);

	PageVO<AccountVO> page(AccountPageParam param);

	LoginVO login(String account, String password);

	void updatePassword(String password, String newPassword);

	AccountDetailVO selectLoginUserInfo();
}
