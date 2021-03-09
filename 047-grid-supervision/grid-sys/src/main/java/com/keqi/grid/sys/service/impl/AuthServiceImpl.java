package com.keqi.grid.sys.service.impl;

import com.keqi.grid.sys.domain.bo.LoginUserBO;
import com.keqi.grid.sys.domain.db.AccountDO;
import com.keqi.grid.sys.domain.db.LoginAccountDO;
import com.keqi.grid.sys.domain.param.LoginParam;
import com.keqi.grid.sys.domain.vo.LoginVO;
import com.keqi.grid.sys.mapper.AccountMapper;
import com.keqi.grid.sys.mapper.LoginAccountMapper;
import com.keqi.grid.sys.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private LoginAccountMapper loginAccountMapper;

    @Override
    public LoginVO login(LoginParam param) {
        AccountDO t = new AccountDO();
        t.setAccount(param.getAccount());
        AccountDO accountDO = this.accountMapper.find(t);
        String token = UUID.randomUUID().toString().replaceAll("-", "");

        LoginAccountDO loginAccountDO = new LoginAccountDO(token, accountDO.getId());
        this.loginAccountMapper.insert(loginAccountDO);

        return new LoginVO(token);
    }

    @Override
    public LoginUserBO findLoginAccountByToken(String token) {

        return null;
    }
}
