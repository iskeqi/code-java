package com.keqi.apihu.manage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.keqi.apihu.core.common.CommonConstant;
import com.keqi.apihu.core.common.LoginUserBO;
import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.core.exception.CustomerException;
import com.keqi.apihu.core.util.JWTUtil;
import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.domain.AccountPageParam;
import com.keqi.apihu.manage.domain.AccountPageVO;
import com.keqi.apihu.manage.mapper.AccountMapper;
import com.keqi.apihu.manage.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountDO> implements AccountService {

	/**
	 * 新增用户
	 *
	 * @param accountDO accountDO
	 */
	@Override
	@Transactional
	public void createAccount(AccountDO accountDO) {
		LambdaQueryWrapper<AccountDO> lambdaQueryWrapper = new LambdaQueryWrapper<AccountDO>()
				.eq(AccountDO::getAccount, accountDO.getAccount());
		AccountDO temp = this.getOne(lambdaQueryWrapper);
		if (temp != null) {
			throw new CustomerException("当前用户名已存在");
		}
		// 两次SHA256加密
		accountDO.setPassword(SecureUtil.sha256(SecureUtil.sha256(CommonConstant.DEFAULT_PASSWORD)));
		this.save(accountDO);
	}

	/**
	 * 删除用户
	 *
	 * @param accountId accountId
	 */
	@Override
	@Transactional
	public void deleteAccount(Integer accountId) {
		this.removeById(accountId);
	}

	/**
	 * 修改用户
	 *
	 * @param accountDO accountDO
	 */
	@Override
	public void updateAccount(AccountDO accountDO) {
		if (StrUtil.isNotBlank(accountDO.getPassword())) {
			throw new CustomerException("非法操作");
		}
		this.updateById(accountDO);
	}

	/**
	 * 查询用户列表
	 *
	 * @param accountPageParam accountPageParam
	 * @return r
	 */
	@Override
	public PageVO pageAccount(AccountPageParam accountPageParam) {
		// select * from sys_account where account = 'a' or nickName = 'b' order by updateTime desc limit 1,2
		LambdaQueryWrapper<AccountDO> lambdaQueryWrapper = new LambdaQueryWrapper<AccountDO>()
				.eq(StrUtil.isNotBlank(accountPageParam.getAccount()),
						AccountDO::getAccount, accountPageParam.getAccount())
				.or()
				.eq(StrUtil.isNotBlank(accountPageParam.getNickName()),
						AccountDO::getNickName, accountPageParam.getNickName())
				.orderByDesc(AccountDO::getUpdateTime);
		Page<AccountDO> page = this.page(new Page<>(accountPageParam.getPageNum(),
				accountPageParam.getPageSize()), lambdaQueryWrapper);

		// VO 转换
		List<AccountPageVO> accountPageVOList = new ArrayList<>(page.getRecords().size());
		for (AccountDO record : page.getRecords()) {
			AccountPageVO accountPageVO = new AccountPageVO();
			BeanUtil.copyProperties(record, accountPageVO);
			// 其他字段()
			accountPageVOList.add(accountPageVO);
		}
		PageVO pageVO = new PageVO();
		pageVO.setTotal(page.getTotal());
		pageVO.setList(accountPageVOList);

		return pageVO;
	}

	/**
	 * 登录
	 *
	 * @param account  account
	 * @param password password
	 * @return r
	 */
	@Override
	public String login(String account, String password) {
		// select * from sys_account where account = 'a'
		LambdaQueryWrapper<AccountDO> lambdaQueryWrapper = new LambdaQueryWrapper<AccountDO>()
				.eq(AccountDO::getAccount, account);
		AccountDO accountDO = this.getOne(lambdaQueryWrapper);
		if (!accountDO.getPassword().equals(SecureUtil.sha256(SecureUtil.sha256(password)))) {
			throw new CustomerException("用户名或密码错误");
		}

		// token过期时间为第二天的凌晨1点钟
		String expirationDateStr = LocalDate.now().plusDays(1L).toString() + " 01:00:00";
		Date expirationDate = DateUtil.parse(expirationDateStr).toJdkDate();

		LoginUserBO loginUserBO = new LoginUserBO();
		BeanUtil.copyProperties(accountDO, loginUserBO);
		Map<String, Object> loginUserMap = BeanUtil.beanToMap(loginUserBO);

		return JWTUtil.generateToken(loginUserMap, expirationDate);
	}
}
