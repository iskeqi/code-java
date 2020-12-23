package com.keqi.knife4j.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.keqi.knife4j.core.auth.LoginUserBO;
import com.keqi.knife4j.core.exception.BusinessException;
import com.keqi.knife4j.core.util.CommonUtil;
import com.keqi.knife4j.core.util.JwtUtil;
import com.keqi.knife4j.sys.domain.db.AccountDO;
import com.keqi.knife4j.sys.domain.param.AccountParam;
import com.keqi.knife4j.sys.domain.vo.LoginVO;
import com.keqi.knife4j.sys.mapper.AccountMapper;
import com.keqi.knife4j.sys.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    /**
     * 登录
     *
     * @param account  account
     * @param password password
     * @return r
     */
    @Override
    public LoginVO login(String account, String password) {
        AccountDO accountDO = this.accountMapper.getByAccount(account);
        String passwordEncry = CommonUtil.encryptedPassword(account, password);

        if (Objects.isNull(accountDO) || !Objects.equals(passwordEncry, accountDO.getPassword())) {
            throw new BusinessException("用户名或密码错误");
        }

        // 生成 JWT 字符串
        LoginUserBO loginUserBO = new LoginUserBO();
        BeanUtil.copyProperties(accountDO, loginUserBO);

        // 设置过期时间为第二天的凌晨 2 点钟
        LocalDateTime expirationDate = LocalDate.now().plusDays(1).atTime(2,0,0);
        String accessToken = JwtUtil.generateToken(BeanUtil.beanToMap(loginUserBO), DateUtil.date(expirationDate));

        LoginVO loginVO = new LoginVO();
        loginVO.setAccessToken(accessToken);

        return loginVO;
    }

    /**
     * 新增用户
     *
     * @param accountParam accountParam
     */
    @Override
    @Transactional
    public void insert(AccountParam accountParam) {
        AccountDO accountDO = new AccountDO();
        BeanUtil.copyProperties(accountParam, accountDO);

        this.accountMapper.insert(accountDO);
    }
}
