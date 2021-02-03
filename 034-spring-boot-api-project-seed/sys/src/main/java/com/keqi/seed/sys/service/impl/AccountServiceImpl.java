package com.keqi.seed.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.seed.core.auth.Auth;
import com.keqi.seed.core.auth.LoginUserBO;
import com.keqi.seed.core.exception.BusinessException;
import com.keqi.seed.core.pojo.CommonConstant;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.core.util.CommonUtil;
import com.keqi.seed.core.util.JsonUtil;
import com.keqi.seed.sys.domain.db.AccountDO;
import com.keqi.seed.sys.domain.db.AccountRoleDO;
import com.keqi.seed.sys.domain.param.AccountPageParam;
import com.keqi.seed.sys.domain.param.AccountParam;
import com.keqi.seed.sys.domain.vo.AccountDetailVO;
import com.keqi.seed.sys.domain.vo.AccountVO;
import com.keqi.seed.sys.domain.vo.LoginVO;
import com.keqi.seed.sys.mapper.AccountMapper;
import com.keqi.seed.sys.mapper.AccountRoleMapper;
import com.keqi.seed.sys.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountRoleMapper accountRoleMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    @Transactional
    public void insert(AccountParam param) {
        AccountDO accountDO = BeanUtil.copyProperties(param, AccountDO.class);
        accountDO.setSalt(RandomUtil.randomString(20));
        accountDO.setPassword(CommonUtil.encryptedPassword(accountDO.getPassword(), accountDO.getSalt()));
        this.accountMapper.insert(accountDO);

        List<Long> roleIdList = param.getRoleIdList();
        if (CollUtil.isNotEmpty(roleIdList)) {
            List<AccountRoleDO> list = new ArrayList<>();
            for (Long roleId : roleIdList) {
                AccountRoleDO t = new AccountRoleDO();
                t.setRoleId(roleId);
                t.setAccountId(accountDO.getId());
                list.add(t);
            }
            this.accountRoleMapper.insertList(list);
        }
    }

    @Override
    @Transactional
    public void updateById(AccountParam param) {
        param.setAccount(null); // 不允许修改
        param.setPassword(null); // 不允许通过此接口修改密码
        AccountDO accountDO = BeanUtil.copyProperties(param, AccountDO.class);
        this.accountMapper.updateById(accountDO);

        List<Long> roleIdList = param.getRoleIdList();
        if (CollUtil.isNotEmpty(roleIdList)) {
            this.accountRoleMapper.deleteByAccountId(param.getId());

            List<AccountRoleDO> list = new ArrayList<>();
            for (Long roleId : roleIdList) {
                AccountRoleDO t = new AccountRoleDO();
                t.setRoleId(roleId);
                t.setAccountId(param.getId());
                list.add(t);
            }
            this.accountRoleMapper.insertList(list);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.accountRoleMapper.deleteByAccountId(id);
        this.accountMapper.deleteById(id);
    }

    @Override
    public PageVO<AccountVO> page(AccountPageParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<AccountVO> result = this.accountMapper.page(param);

        return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
    }

    @Override
    public LoginVO login(String account, String password) {
        AccountDO accountDO = this.accountMapper.selectByAccount(account);
        if (Objects.isNull(accountDO)) {
            throw new BusinessException("用户名不存在");
        }

        String passwordEncry = CommonUtil.encryptedPassword(password, accountDO.getSalt());
        if (!Objects.equals(passwordEncry, accountDO.getPassword())) {
            throw new BusinessException("密码错误");
        }

        // token 有效期为 14 天
        long expirationTime = System.currentTimeMillis() + 1209600000;
        String token = UUID.randomUUID().toString().replace("-", "");

        LoginUserBO loginUserBO = new LoginUserBO();
        loginUserBO.setId(accountDO.getId());
        loginUserBO.setAccount(accountDO.getAccount());
        loginUserBO.setExpirationTime(expirationTime);
        loginUserBO.setToken(token);

        stringRedisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public <K, V> Object execute(RedisOperations<K, V> operations) throws DataAccessException {
                StringRedisTemplate template = (StringRedisTemplate) operations;
                template.multi();

                String loginInfo = JsonUtil.writeValueAsString(loginUserBO);
                template.opsForHash().put(CommonConstant.UUID_LOGIN_INFO, token, loginInfo);
                template.opsForHash().put(CommonConstant.ACCOUNT_ID_LOGIN_INFO, String.valueOf(accountDO.getId()), loginInfo);

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
