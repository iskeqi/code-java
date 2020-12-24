package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.sys.domain.param.AccountParam;
import com.keqi.knife4j.sys.domain.vo.LoginVO;

public interface AccountService {

	/**
	 * 登录
	 *
	 * @param account  account
	 * @param password password
	 * @return r
	 */
	LoginVO login(String account, String password);

	/**
	 * 新增用户
	 *
	 * @param accountParam accountParam
	 */
	void insert(AccountParam accountParam);

	/**
	 * 修改密码
	 *
	 * @param password    password
	 * @param newPassword newPassword
	 */
	void updatePassword(String password, String newPassword);
}
