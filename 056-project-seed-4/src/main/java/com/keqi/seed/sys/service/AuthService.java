package com.keqi.seed.sys.service;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.keqi.seed.core.exception.BusinessException;
import com.keqi.seed.sys.domain.db.AccountDO;
import com.keqi.seed.sys.domain.dto.AuthDto;
import com.keqi.seed.sys.domain.param.AuthParam;
import com.keqi.seed.sys.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    private AccountMapper accountMapper;

    public AuthDto auth(AuthParam param) {
        AccountDO t = accountMapper.selectOne(Wrappers.query(new AccountDO().setAccount(param.getUsername())));
        if (t == null) {
            throw new BusinessException("用户名或密码不正确");
        }
        String password = SaSecureUtil.sha256(t.getSalt() + param.getPassword() + t.getAccount());
        if (!Objects.equals(password, t.getPassword())) {
            throw new BusinessException("用户名或密码不正确");
        }

        StpUtil.login(param.getUsername(), param.getDevice());
        return new AuthDto(StpUtil.getTokenInfo().getTokenValue());
    }
}
