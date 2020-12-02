package com.keqi.bestpracticeone.sys.service;

import com.keqi.bestpracticeone.sys.domain.vo.LoginVO;

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
