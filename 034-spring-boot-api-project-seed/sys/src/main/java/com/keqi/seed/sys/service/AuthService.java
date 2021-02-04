package com.keqi.seed.sys.service;

import com.keqi.seed.sys.domain.param.LoginParam;
import com.keqi.seed.sys.domain.vo.AccountDetailVO;
import com.keqi.seed.sys.domain.vo.LoginVO;

public interface AuthService {

    LoginVO login(LoginParam param);

    void updatePassword(String password, String newPassword);

    AccountDetailVO selectLoginUserInfo();

}
