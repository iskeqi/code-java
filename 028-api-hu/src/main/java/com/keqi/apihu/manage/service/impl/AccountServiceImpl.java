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
import com.keqi.apihu.manage.domain.AccountListParam;
import com.keqi.apihu.manage.domain.LoginVO;
import com.keqi.apihu.manage.domain.UserTypeEnum;
import com.keqi.apihu.manage.mapper.AccountMapper;
import com.keqi.apihu.manage.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountMapper accountMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return accountMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(AccountDO record) {
		return accountMapper.insert(record);
	}

	@Override
	public int insertOrUpdate(AccountDO record) {
		return accountMapper.insertOrUpdate(record);
	}

	@Override
	public int insertOrUpdateSelective(AccountDO record) {
		return accountMapper.insertOrUpdateSelective(record);
	}

	@Override
	public int insertSelective(AccountDO record) {
		return accountMapper.insertSelective(record);
	}

	@Override
	public AccountDO selectByPrimaryKey(Long id) {
		return accountMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AccountDO record) {
		return accountMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AccountDO record) {
		return accountMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateBatch(List<AccountDO> list) {
		return accountMapper.updateBatch(list);
	}

	@Override
	public int updateBatchSelective(List<AccountDO> list) {
		return accountMapper.updateBatchSelective(list);
	}

	@Override
	public int batchInsert(List<AccountDO> list) {
		return accountMapper.batchInsert(list);
	}

	/**
	 * 创建用户
	 *
	 * @param accountDO accountDO
	 */
	@Override
	@Transactional
	public void createAccount(AccountDO accountDO) {
		String password = CommonUtil.encryptedPassword(accountDO.getAccount(), CommonConstant.DEFAULT_PASSWORD);
		accountDO.setPassword(password);
		this.accountMapper.insert(accountDO);
	}

	/**
	 * 根据用户id删除用户
	 *
	 * @param id
	 */
	@Override
	@Transactional
	public void deleteAccountById(Long id) {
		this.accountMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据用户ID修改用户信息
	 *
	 * @param accountDO accountDO
	 */
	@Override
	@Transactional
	public void updateAccountById(AccountDO accountDO) {
		this.accountMapper.updateByPrimaryKeySelective(accountDO);
	}

	/**
	 * 查询用户列表
	 *
	 * @param accountListParam accountListParam
	 * @return r
	 */
	@Override
	public PageVO listAccount(AccountListParam accountListParam) {

		long total = this.accountMapper.count(accountListParam);
		List<AccountDO> accountDOList = new ArrayList<>();
		if (total > 0) {
			accountDOList = this.accountMapper.listAccount(accountListParam);
		}

		return new PageVO(total, accountDOList);
	}

	/**
	 * 批量删除用户
	 *
	 * @param ids ids
	 */
	@Override
	@Transactional
	public void deleteAccountByIds(Long[] ids) {
		this.accountMapper.batchDelete(ids);
	}

	/**
	 * 登录
	 *
	 * @param account  account
	 * @param password password
	 * @return r
	 */
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

	/**
	 * 修改密码
	 *
	 * @param account loginAccount
	 * @param password password
	 */
	@Override
	@Transactional
	public void updatePassword(String account, String password) {
		password = CommonUtil.encryptedPassword(account, password);
		this.accountMapper.updatePasswordByAccount(account, password);
	}

}
