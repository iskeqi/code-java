package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.AccountDO;
import com.keqi.grid.sys.domain.param.AccountPageParam;
import com.keqi.grid.sys.domain.param.AccountParam;
import com.keqi.grid.sys.domain.vo.AccountVO;
import com.keqi.grid.sys.mapper.AccountMapper;
import com.keqi.grid.sys.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	@Override
	@Transactional
	public void insert(AccountParam param) {
		AccountDO t = BeanUtil.copyProperties(param, AccountDO.class);
		this.accountMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(AccountParam param) {
		AccountDO t = BeanUtil.copyProperties(param, AccountDO.class);
		this.accountMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.accountMapper.deleteById(id);
	}

	@Override
	public PageVO<AccountVO> page(AccountPageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		// List<AccountVO> result = this.accountMapper.page(param);

		// return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
		return null;
	}
}
