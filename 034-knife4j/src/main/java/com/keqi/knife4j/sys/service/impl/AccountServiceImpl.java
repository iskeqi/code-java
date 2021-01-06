package com.keqi.knife4j.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.knife4j.core.auth.Auth;
import com.keqi.knife4j.core.auth.LoginUserBO;
import com.keqi.knife4j.core.exception.BusinessException;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.core.util.CommonUtil;
import com.keqi.knife4j.core.util.JwtUtil;
import com.keqi.knife4j.sys.domain.db.AccountDO;
import com.keqi.knife4j.sys.domain.db.AccountRoleDO;
import com.keqi.knife4j.sys.domain.param.AccountPageParam;
import com.keqi.knife4j.sys.domain.param.AccountParam;
import com.keqi.knife4j.sys.domain.vo.AccountVO;
import com.keqi.knife4j.sys.domain.vo.LoginVO;
import com.keqi.knife4j.sys.mapper.AccountMapper;
import com.keqi.knife4j.sys.mapper.AccountRoleMapper;
import com.keqi.knife4j.sys.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

	private final AccountMapper accountMapper;
	private final AccountRoleMapper accountRoleMapper;

	/**
	 * 登录
	 *
	 * @param account  account
	 * @param password password
	 * @return r
	 */
	@Override
	public LoginVO login(String account, String password) {
		AccountDO accountDO = this.accountMapper.getByAccount(account);
		String passwordEncry = CommonUtil.encryptedPassword(password, accountDO.getSalt());

		if (Objects.isNull(accountDO) || !Objects.equals(passwordEncry, accountDO.getPassword())) {
			throw new BusinessException("用户名或密码错误");
		}

		// 生成 JWT 字符串
		LoginUserBO loginUserBO = new LoginUserBO();
		BeanUtil.copyProperties(accountDO, loginUserBO);

		// 设置过期时间为第二天的凌晨 2 点钟
		LocalDateTime expirationDate = LocalDate.now().plusDays(1).atTime(2, 0, 0);
		String accessToken = JwtUtil.generateToken(BeanUtil.beanToMap(loginUserBO), DateUtil.date(expirationDate));

		LoginVO loginVO = new LoginVO();
		loginVO.setAccessToken(accessToken);

		return loginVO;
	}

	/**
	 * 新增用户
	 *
	 * @param accountParam accountParam
	 */
	@Override
	@Transactional
	public void insert(AccountParam accountParam) {
		// 新增用户记录
		AccountDO accountDO = new AccountDO();
		BeanUtil.copyProperties(accountParam, accountDO);
		accountDO.setSalt(RandomUtil.randomString(20));
		accountDO.setPassword(CommonUtil.encryptedPassword(accountDO.getPassword(), accountDO.getSalt()));
		this.accountMapper.insert(accountDO);

		// 新增用户-角色关联记录
		List<Long> roleIdList = accountParam.getRoleIdList();
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

	/**
	 * 修改密码
	 *
	 * @param password    password
	 * @param newPassword newPassword
	 */
	@Override
	@Transactional
	public void updatePassword(String password, String newPassword) {
		Long id = Auth.getLoginAccountId();
		AccountDO accountDO = this.accountMapper.selectById(id);

		if (CommonUtil.encryptedPassword(password, accountDO.getSalt())
				.equals(accountDO.getPassword())) {
			// 密码正确，修改密码
			this.accountMapper.updatePasswordById(
					CommonUtil.encryptedPassword(newPassword, accountDO.getSalt()), id);
		} else {
			throw new BusinessException("请输入正确的密码");
		}
	}

	/**
	 * 根据ID修改用户
	 *
	 * @param accountParam accountParam
	 */
	@Override
	@Transactional
	public void updateById(AccountParam accountParam) {
		// 修改用户记录
		accountParam.setAccount(null); // 不允许修改
		accountParam.setPassword(null); // 不允许通过此接口修改密码
		AccountDO accountDO = new AccountDO();
		BeanUtil.copyProperties(accountParam, accountDO);
		this.accountMapper.updateById(accountDO);

		// 修改用户-角色关联记录
		List<Long> roleIdList = accountParam.getRoleIdList();
		if (CollUtil.isNotEmpty(roleIdList)) {
			// 先删除
			this.accountRoleMapper.deleteByAccountId(accountParam.getId());

			// 再增加
			List<AccountRoleDO> list = new ArrayList<>();
			for (Long roleId : roleIdList) {
				AccountRoleDO t = new AccountRoleDO();
				t.setRoleId(roleId);
				t.setAccountId(accountParam.getId());
				list.add(t);
			}
			this.accountRoleMapper.insertList(list);
		}
	}

	/**
	 * 根据ID删除用户
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {
		this.accountRoleMapper.deleteByAccountId(id);
		this.accountMapper.deleteById(id);
	}

	/**
	 * 分页查询用户列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	@Override
	public PageVO<AccountVO> page(AccountPageParam pageParam) {
		Page<AccountVO> page = new Page<>(pageParam.getCurrent(), pageParam.getSize());
		IPage<AccountVO> result = this.accountMapper.page(page, pageParam);

		return new PageVO<>(result.getTotal(), result.getRecords());
	}
}
