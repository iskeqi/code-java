package com.keqi.grid.sys.service;

import com.keqi.grid.sys.domain.bo.LoginUserBO;
import com.keqi.grid.sys.domain.param.LoginParam;
import com.keqi.grid.sys.domain.vo.LoginVO;

public interface AuthService {

    LoginVO login(LoginParam param);

    LoginUserBO findLoginAccountByToken(String token);
}
