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

	/**
	 * 登录
	 *
	 * @param account  account
	 * @param password password
	 * @return r
	 */
	LoginVO login(String account, String password);

	/**
	 * 修改密码
	 *
	 * @param password    password
	 * @param newPassword newPassword
	 */
	void updatePassword(String password, String newPassword);

	/**
	 * 获取登录用户信息
	 *
	 * @return r
	 */
	AccountDetailVO getLoginUserInfo();

}
