package com.keqi.apihu.manage.service;

import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.domain.param.AccountListParam;
import com.keqi.apihu.manage.domain.vo.LoginVO;

public interface AccountService {

	/**
	 * 创建用户
	 *
	 * @param accountDO accountDO
	 */
	void createAccount(AccountDO accountDO);

	/**
	 * 根据用户id删除用户
	 *
	 * @param id
	 */
	void deleteAccountById(Long id);

	/**
	 * 根据用户ID修改用户信息
	 *
	 * @param accountDO accountDO
	 */
	void updateAccountById(AccountDO accountDO);

	/**
	 * 查询用户列表
	 *
	 * @param accountListParam accountListParam
	 * @return r
	 */
	PageVO listAccount(AccountListParam accountListParam);

	/**
	 * 批量删除用户
	 *
	 * @param ids ids
	 */
	void deleteAccountByIds(Long[] ids);

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
	 * @param account account
	 * @param oldPassword oldPassword
	 * @param newPassword newPassword
	 */
	void updatePassword(String account, String oldPassword, String newPassword);

	/**
	 * 重置密码
	 * @param  account account
	 */
	void resetPassword(String account);

}
