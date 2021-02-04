package com.keqi.seed.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.AccountDO;
import com.keqi.seed.sys.domain.db.AccountRoleDO;
import com.keqi.seed.sys.domain.param.AccountPageParam;
import com.keqi.seed.sys.domain.param.AccountParam;
import com.keqi.seed.sys.domain.vo.AccountVO;
import com.keqi.seed.sys.mapper.AccountMapper;
import com.keqi.seed.sys.mapper.AccountRoleMapper;
import com.keqi.seed.sys.service.AccountService;
import com.keqi.seed.sys.util.SysUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountRoleMapper accountRoleMapper;

    @Override
    @Transactional
    public void insert(AccountParam param) {
        AccountDO accountDO = BeanUtil.copyProperties(param, AccountDO.class);
        accountDO.setSalt(RandomUtil.randomString(20));
        accountDO.setPassword(SysUtil.encryptedPassword(accountDO.getPassword(), accountDO.getSalt()));
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
}
