package com.keqi.seed.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.keqi.seed.core.exception.BusinessException;
import com.keqi.seed.core.pojo.BaseService;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.AccountRoleDO;
import com.keqi.seed.sys.domain.db.RoleDO;
import com.keqi.seed.sys.domain.db.RoleMenuDO;
import com.keqi.seed.sys.domain.param.RolePageParam;
import com.keqi.seed.sys.mapper.AccountRoleMapper;
import com.keqi.seed.sys.mapper.RoleMapper;
import com.keqi.seed.sys.mapper.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService implements BaseService<RoleDO> {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AccountRoleMapper accountRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public RoleDO insert(RoleDO roleDO) {
        roleMapper.insert(roleDO);
        return roleDO;
    }

    @Transactional
    @Override
    public int deleteById(String id) {
        LambdaQueryWrapper<AccountRoleDO> query1 = Wrappers.lambdaQuery(AccountRoleDO.class)
                .eq(AccountRoleDO::getRoleId, id);
        int count = accountRoleMapper.selectCount(query1);
        if (count > 0) {
            throw new BusinessException("当前角色已使用，无法删除");
        }

        LambdaQueryWrapper<RoleMenuDO> query2 = Wrappers.lambdaQuery(RoleMenuDO.class)
                .eq(RoleMenuDO::getRoleId, id);
        roleMenuMapper.delete(query2);

        return roleMapper.deleteById(id);
    }

    @Override
    public int updateById(RoleDO roleDO) {
        return roleMapper.updateById(roleDO);
    }

    @Override
    public RoleDO getById(String id) {
        return roleMapper.selectById(id);
    }

    public PageVO<RoleDO> page(RolePageParam param) {
        IPage<RoleDO> page = roleMapper.page(param);
        return new PageVO<>(page.getTotal(), page.getRecords());
    }
}
