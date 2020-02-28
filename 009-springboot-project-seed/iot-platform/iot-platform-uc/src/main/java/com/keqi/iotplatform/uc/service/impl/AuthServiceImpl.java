package com.keqi.iotplatform.uc.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.keqi.iotplatform.uc.domain.AccountDO;
import com.keqi.iotplatform.uc.domain.AuthVO;
import com.keqi.iotplatform.uc.mapper.AccountMapper;
import com.keqi.iotplatform.uc.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final AccountMapper accountMapper;

	/**
	 * 登录
	 *
	 * @param account  account
	 * @param password password
	 * @return r
	 */
	@Override
	public AuthVO auth(String account, String password) {
		// 1、根据用户名查询用户信息
		LambdaQueryWrapper<AccountDO> l = new LambdaQueryWrapper();
		l.eq(AccountDO::getAccount, account);
		AccountDO accountDO = accountMapper.selectOne(l);

		String pwd = accountDO.getPassword();


		if (pwd.equalsIgnoreCase(SecureUtil.md5(password))) {
			AuthVO authVO = new AuthVO();
			authVO.setAccessToken(IdUtil.randomUUID());
			authVO.setUiTheme(accountDO.getUiTheme());
			authVO.setUserType(accountDO.getUserType());
			authVO.setUpdatePasswordFlag(accountDO.getUpdatePasswordFlag());
			return authVO;
		}
		return null;
	}
}
