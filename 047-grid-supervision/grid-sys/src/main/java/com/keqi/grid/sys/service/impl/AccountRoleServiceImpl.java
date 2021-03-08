package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.AccountRoleDO;
import com.keqi.grid.sys.domain.param.AccountRolePageParam;
import com.keqi.grid.sys.domain.param.AccountRoleParam;
import com.keqi.grid.sys.domain.vo.AccountRoleVO;
import com.keqi.grid.sys.mapper.AccountRoleMapper;
import com.keqi.grid.sys.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {

	@Autowired
	private AccountRoleMapper accountRoleMapper;

	@Override
	@Transactional
	public void insert(AccountRoleParam param) {
		AccountRoleDO t = BeanUtil.copyProperties(param, AccountRoleDO.class);
		this.accountRoleMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(AccountRoleParam param) {
		AccountRoleDO t = BeanUtil.copyProperties(param, AccountRoleDO.class);
		this.accountRoleMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.accountRoleMapper.deleteById(id);
	}

	@Override
	public PageVO<AccountRoleVO> page(AccountRolePageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		// List<AccountRoleVO> result = this.accountRoleMapper.page(param);

		// return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
		return null;
	}
}
