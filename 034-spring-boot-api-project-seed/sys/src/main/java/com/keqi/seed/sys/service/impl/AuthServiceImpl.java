package com.keqi.seed.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.seed.core.auth.Auth;
import com.keqi.seed.core.auth.LoginUserBO;
import com.keqi.seed.core.exception.BusinessException;
import com.keqi.seed.core.pojo.CommonConstant;
import com.keqi.seed.core.util.CommonUtil;
import com.keqi.seed.core.util.JsonUtil;
import com.keqi.seed.sys.domain.db.AccountDO;
import com.keqi.seed.sys.domain.param.LoginParam;
import com.keqi.seed.sys.domain.vo.AccountDetailVO;
import com.keqi.seed.sys.domain.vo.LoginVO;
import com.keqi.seed.sys.mapper.AccountMapper;
import com.keqi.seed.sys.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public LoginVO login(LoginParam param) {
        AccountDO accountDO = this.accountMapper.selectByAccount(param.getAccount());
        if (Objects.isNull(accountDO)) {
            throw new BusinessException("用户名不存在");
        }

        String passwordEncry = CommonUtil.encryptedPassword(param.getPassword(), accountDO.getSalt());
        if (!Objects.equals(passwordEncry, accountDO.getPassword())) {
            throw new BusinessException("密码错误");
        }

        // token 有效期为 14 天
        long expirationTime = System.currentTimeMillis() + 1209600000;
        String token = UUID.randomUUID().toString().replace("-", "")  + param.getDevType();

        LoginUserBO loginUserBO = new LoginUserBO();
        loginUserBO.setId(accountDO.getId());
        loginUserBO.setAccount(accountDO.getAccount());
        loginUserBO.setExpirationTime(expirationTime);
        loginUserBO.setToken(token);
        loginUserBO.setDevType(param.getDevType());

        String o = (String) stringRedisTemplate.opsForHash().get(CommonConstant.ACCOUNT_LOGIN_INFO, accountDO.getAccount() + param.getDevType());

        stringRedisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public <K, V> Object execute(RedisOperations<K, V> operations) throws DataAccessException {
                StringRedisTemplate template = (StringRedisTemplate) operations;
                template.multi();

                if (o != null) {
                    // 强制下线
                    LoginUserBO t = JsonUtil.readValue(o, LoginUserBO.class);
                    template.opsForHash().delete(CommonConstant.UUID_LOGIN_INFO, t.getToken());
                    template.opsForHash().delete(CommonConstant.ACCOUNT_LOGIN_INFO, t.getAccount() + t.getDevType());
                    template.opsForSet().add(CommonConstant.UUID_LOGOUT_INFO, t.getToken());
                }

                String loginInfo = JsonUtil.writeValueAsString(loginUserBO);
                template.opsForHash().put(CommonConstant.UUID_LOGIN_INFO, token, loginInfo);
                template.opsForHash().put(CommonConstant.ACCOUNT_LOGIN_INFO, accountDO.getAccount() + param.getDevType(), loginInfo);

                return template.exec();
            }
        });

        return new LoginVO(token);
    }

    @Override
    @Transactional
    public void updatePassword(String password, String newPassword) {
        Long id = Auth.getLoginAccountId();
        AccountDO accountDO = this.accountMapper.selectById(id);

        if (CommonUtil.encryptedPassword(password, accountDO.getSalt())
                .equals(accountDO.getPassword())) {
            this.accountMapper.updatePasswordById(
                    CommonUtil.encryptedPassword(newPassword, accountDO.getSalt()), id);
        } else {
            throw new BusinessException("请输入正确的密码");
        }
    }

    @Override
    public AccountDetailVO selectLoginUserInfo() {
        AccountDO accountDO = this.accountMapper.selectById(Auth.getLoginAccountId());
        return BeanUtil.copyProperties(accountDO, AccountDetailVO.class);
    }
}
