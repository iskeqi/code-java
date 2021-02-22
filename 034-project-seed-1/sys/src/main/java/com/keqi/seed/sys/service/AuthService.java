package com.keqi.seed.sys.service;

import com.keqi.seed.sys.domain.param.LoginParam;
import com.keqi.seed.sys.domain.vo.AccountDetailVO;
import com.keqi.seed.sys.domain.vo.LoginVO;
import com.keqi.seed.sys.domain.vo.MenuVO;

import java.util.List;

public interface AuthService {

    LoginVO login(LoginParam param);

    void updatePassword(String password, String newPassword);

    AccountDetailVO selectLoginUserInfo();

    void logout(String token);

    List<MenuVO> selectMenusByAccountId(String token, Long accountId);
}
