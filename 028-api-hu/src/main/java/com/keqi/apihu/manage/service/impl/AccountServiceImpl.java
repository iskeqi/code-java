package com.keqi.apihu.manage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.keqi.apihu.core.common.CommonConstant;
import com.keqi.apihu.core.common.LoginUserBO;
import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.core.util.CommonUtil;
import com.keqi.apihu.core.util.JWTUtil;
import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.domain.param.AccountListParam;
import com.keqi.apihu.manage.domain.vo.LoginVO;
import com.keqi.apihu.manage.domain.enums.UserTypeEnum;
import com.keqi.apihu.manage.mapper.AccountMapper;
import com.keqi.apihu.manage.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountMapper accountMapper;

	@Override
	@Transactional
	public void createAccount(AccountDO accountDO) {
		String password = CommonUtil.encryptedPassword(accountDO.getAccount(), CommonConstant.DEFAULT_PASSWORD);
		accountDO.setPassword(password);
		this.accountMapper.insert(accountDO);
	}

	@Override
	@Transactional
	public void deleteAccountById(Long id) {
		this.accountMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public void updateAccountById(AccountDO accountDO) {
		this.accountMapper.updateByPrimaryKeySelective(accountDO);
	}

	@Override
	public PageVO listAccount(AccountListParam accountListParam) {

		long total = this.accountMapper.count(accountListParam);
		List<AccountDO> accountDOList = new ArrayList<>();
		if (total > 0) {
			accountDOList = this.accountMapper.listAccount(accountListParam);
		}

		return new PageVO(total, accountDOList);
	}

	@Override
	@Transactional
	public void deleteAccountByIds(Long[] ids) {
		this.accountMapper.batchDelete(ids);
	}

	@Override
	public LoginVO login(String account, String password) {
		AccountDO accountDO = this.accountMapper.findOneByAccount(account);

		if (accountDO == null ||
				!Objects.equals(accountDO.getPassword(), CommonUtil.encryptedPassword(account, password))) {
			throw new BusinessException("用户名或密码错误");
		}

		UserTypeEnum userTypeEnum = CommonConstant.SUPER_ADMIN.equals(account) ? UserTypeEnum.SUPER_ADMIN : UserTypeEnum.COMMON_USER;
		accountDO.setPassword(null);
		accountDO.setUserType(userTypeEnum);
		LoginUserBO loginUserBO = new LoginUserBO();
		BeanUtil.copyProperties(accountDO, loginUserBO);

		// 过期时间设置为第二天的凌晨两点钟
		LocalDateTime expirationDate = LocalDateTime.of(LocalDate.now().plusDays(1L), LocalTime.of(2, 0, 0));
		String accessToken = JWTUtil.generateToken(BeanUtil.beanToMap(loginUserBO), DateUtil.date(expirationDate));

		return LoginVO.builder().
				accessToken(accessToken).
				userType(userTypeEnum).
				build();
	}

	@Override
	@Transactional
	public void updatePassword(String account, String oldPassword, String newPassword) {
		AccountDO accountDO = this.accountMapper.findOneByAccount(account);
		if (accountDO == null ||
				!Objects.equals(accountDO.getPassword(), CommonUtil.encryptedPassword(account, oldPassword))) {
			throw new BusinessException("用户名或密码错误");
		}

		newPassword = CommonUtil.encryptedPassword(account, newPassword);
		this.accountMapper.updatePasswordByAccount(account, newPassword);
	}

	@Override
	public void resetPassword(String account) {
		this.accountMapper.updatePasswordByAccount(account,
				CommonUtil.encryptedPassword(account, CommonConstant.DEFAULT_PASSWORD));
	}

}
