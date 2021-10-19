package com.keqi.seed.sys.service;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.util.SaFoxUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.keqi.seed.core.exception.BusinessException;
import com.keqi.seed.core.pojo.BaseService;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.AccountDO;
import com.keqi.seed.sys.domain.db.AccountRoleDO;
import com.keqi.seed.sys.domain.db.RoleDO;
import com.keqi.seed.sys.domain.param.AccountPageParam;
import com.keqi.seed.sys.mapper.AccountMapper;
import com.keqi.seed.sys.mapper.AccountRoleMapper;
import com.keqi.seed.sys.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements BaseService<AccountDO> {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountRoleMapper accountRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Transactional
    public AccountDO insert(AccountDO accountDO) {
        AccountDO t = accountMapper.selectOne(Wrappers.query(new AccountDO().setAccount(accountDO.getAccount())));
        if (t != null) {
            throw new BusinessException("当前用户名已存在");
        }

        // 新增用户
        accountDO.setSalt(SaFoxUtil.getRandomString(20));
        String password = SaSecureUtil.sha256(accountDO.getSalt() + accountDO.getPassword() + accountDO.getAccount());
        accountDO.setPassword(password);
        accountMapper.insert(accountDO);

        // 绑定关联角色
        batchInsertRoleList(accountDO.getRoleList(), accountDO.getId());

        return accountDO;
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        accountRoleMapper.delete(Wrappers.query(new AccountRoleDO().setAccountId(id)));

        accountMapper.deleteById(id);
    }

    @Transactional
    @Override
    public void updateById(AccountDO accountDO) {
        // 用户名不能更改
        accountDO.setAccount(null);
        accountMapper.updateById(accountDO);

        // 重绑关联角色
        accountRoleMapper.delete(Wrappers.query(new AccountRoleDO().setAccountId(accountDO.getId())));
        batchInsertRoleList(accountDO.getRoleList(), accountDO.getId());
    }

    @Override
    public AccountDO getById(String id) {
        List<AccountRoleDO> roleIdList = accountRoleMapper
                .selectList(Wrappers.query(new AccountRoleDO().setAccountId(id)));
        List<RoleDO> roleList = roleMapper.selectBatchIds(
                roleIdList.stream().map(AccountRoleDO::getRoleId).collect(Collectors.toList()));

        AccountDO t = accountMapper.selectById(id);
        t.setPassword(null);
        t.setSalt(null);
        t.setRoleList(roleList);
        return t;
    }

    public PageVO<AccountDO> page(AccountPageParam param) {
        IPage<AccountDO> page = accountMapper.page(param);
        return new PageVO<>(page.getTotal(), page.getRecords());
    }

    private void batchInsertRoleList(List<RoleDO> roleList, String accountId) {
        if (roleList != null && roleList.size() > 0) {
            for (RoleDO roleDO : roleList) {
                accountRoleMapper.insert(new AccountRoleDO()
                        .setAccountId(accountId)
                        .setRoleId(roleDO.getId()));
            }
        }
    }
}
