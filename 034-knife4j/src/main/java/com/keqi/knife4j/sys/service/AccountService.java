package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.AccountPageParam;
import com.keqi.knife4j.sys.domain.param.AccountParam;
import com.keqi.knife4j.sys.domain.vo.AccountVO;
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

	/**
	 * 根据ID修改用户
	 *
	 * @param accountParam accountParam
	 */
	void updateById(AccountParam accountParam);

	/**
	 * 根据ID删除用户
	 *
	 * @param id id
	 */
	void deleteById(Long id);

	/**
	 * 分页查询用户列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	PageVO<AccountVO> page(AccountPageParam pageParam);
}
