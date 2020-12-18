package com.keqi.apihu.sys.service;

import com.keqi.apihu.sys.domain.vo.LoginVO;

public interface AccountService {

    /**
     * 登录
     *
     * @param account  account
     * @param password password
     * @return r
     */
    LoginVO login(String account, String password);
}
