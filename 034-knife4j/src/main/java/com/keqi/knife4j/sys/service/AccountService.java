package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.AccountPageParam;
import com.keqi.knife4j.sys.domain.param.AccountParam;
import com.keqi.knife4j.sys.domain.vo.AccountDetailVO;
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
	 * @param param param
	 */
	void insert(AccountParam param);

	/**
	 * 修改密码
	 *
	 * @param password    password
	 * @param newPassword newPassword
	 */
	void updatePassword(String password, String newPassword);

	/**
	 * 修改用户
	 *
	 * @param param param
	 */
	void updateById(AccountParam param);

	/**
	 * 删除用户
	 *
	 * @param id id
	 */
	void deleteById(Long id);

	/**
	 * 分页查询用户列表
	 *
	 * @param param param
	 * @return r
	 */
	PageVO<AccountVO> page(AccountPageParam param);

	/**
	 * 获取登录用户信息
	 *
	 * @return r
	 */
	AccountDetailVO getLoginUserInfo();

}
