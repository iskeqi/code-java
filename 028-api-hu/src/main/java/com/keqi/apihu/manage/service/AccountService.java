package com.keqi.apihu.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.domain.AccountPageParam;

public interface AccountService extends IService<AccountDO>{


	/**
	 * 新增用户
	 * @param accountDO accountDO
	 */
	void createAccount(AccountDO accountDO);

	/**
	 * 删除用户
	 * @param accountId accountId
	 */
	void deleteAccount(Integer accountId);

	/**
	 * 修改用户
	 * @param accountDO accountDO
	 */
	void updateAccount(AccountDO accountDO);

	/**
	 * 查询用户列表
	 * @param accountPageParam accountPageParam
	 * @return r
	 */
	PageVO pageAccount(AccountPageParam accountPageParam);

	/**
	 * 登录
	 * @param account account
	 * @param password password
	 * @return r
	 */
	String login(String account, String password);
}
