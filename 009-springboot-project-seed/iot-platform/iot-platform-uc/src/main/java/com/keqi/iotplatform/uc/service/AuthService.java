package com.keqi.iotplatform.uc.service;

import com.keqi.iotplatform.uc.domain.AuthVO;

public interface AuthService {

	/**
	 * 登录
	 * @param account account
	 * @param password password
	 * @return r
	 */
	AuthVO auth(String account, String password);

}
