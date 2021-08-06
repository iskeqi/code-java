package com.keqi.seed.sys.service;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.util.SaFoxUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.keqi.seed.core.pojo.BaseService;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.AccountDO;
import com.keqi.seed.sys.domain.db.AccountRoleDO;
import com.keqi.seed.sys.domain.param.AccountPageParam;
import com.keqi.seed.sys.mapper.AccountMapper;
import com.keqi.seed.sys.mapper.AccountRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService implements BaseService<AccountDO> {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountRoleMapper accountRoleMapper;

    @Override
    public AccountDO insert(AccountDO accountDO) {

        accountDO.setSalt(SaFoxUtil.getRandomString(20));
        String password = SaSecureUtil.sha256(accountDO.getSalt() + accountDO.getPassword() + accountDO.getAccount());
        accountDO.setPassword(password);

        accountMapper.insert(accountDO);
        return accountDO;
    }

    @Transactional
    @Override
    public int deleteById(String id) {
        LambdaQueryWrapper<AccountRoleDO> query1 = Wrappers.lambdaQuery(AccountRoleDO.class)
                .ge(AccountRoleDO::getAccountId, id);
        accountRoleMapper.delete(query1);

        return accountMapper.deleteById(id);
    }

    @Override
    public int updateById(AccountDO accountDO) {
        return accountMapper.updateById(accountDO);
    }

    @Override
    public AccountDO getById(String id) {
        return accountMapper.selectById(id);
    }

    public PageVO<AccountDO> page(AccountPageParam param) {
        IPage<AccountDO> page = accountMapper.page(param);
        return new PageVO<>(page.getTotal(), page.getRecords());
    }
}
