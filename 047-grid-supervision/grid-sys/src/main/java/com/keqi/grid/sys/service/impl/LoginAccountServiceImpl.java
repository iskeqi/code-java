package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.LoginAccountDO;
import com.keqi.grid.sys.domain.param.LoginAccountPageParam;
import com.keqi.grid.sys.domain.param.LoginAccountParam;
import com.keqi.grid.sys.domain.vo.LoginAccountVO;
import com.keqi.grid.sys.mapper.LoginAccountMapper;
import com.keqi.grid.sys.service.LoginAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoginAccountServiceImpl implements LoginAccountService {

	@Autowired
	private LoginAccountMapper loginAccountMapper;

	@Override
	@Transactional
	public void insert(LoginAccountParam param) {
		LoginAccountDO t = BeanUtil.copyProperties(param, LoginAccountDO.class);
		this.loginAccountMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(LoginAccountParam param) {
		LoginAccountDO t = BeanUtil.copyProperties(param, LoginAccountDO.class);
		this.loginAccountMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.loginAccountMapper.deleteById(id);
	}

	@Override
	public PageVO<LoginAccountVO> page(LoginAccountPageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		// List<LoginAccountVO> result = this.loginAccountMapper.page(param);

		// return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
		return null;
	}
}
