package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.keqi.grid.core.exception.BusinessException;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.AccountDO;
import com.keqi.grid.sys.domain.db.AccountRoleDO;
import com.keqi.grid.sys.domain.db.GridAccountDO;
import com.keqi.grid.sys.domain.param.AccountPageParam;
import com.keqi.grid.sys.domain.param.AccountParam;
import com.keqi.grid.sys.domain.vo.AccountVO;
import com.keqi.grid.sys.mapper.AccountMapper;
import com.keqi.grid.sys.mapper.AccountRoleMapper;
import com.keqi.grid.sys.mapper.GridAccountMapper;
import com.keqi.grid.sys.service.AccountService;
import com.keqi.grid.sys.util.SysUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private AccountRoleMapper accountRoleMapper;
	@Autowired
	private GridAccountMapper gridAccountMapper;

	@Override
	@Transactional
	public void insert(AccountParam param) {
		if (param.getRoleId() == 1 &&
				!CollectionUtils.isEmpty(param.getGridIds()) && param.getGridIds().size() > 1) {
			throw new BusinessException("网格员只能归属于一个网格");
		}

		AccountDO t = BeanUtil.copyProperties(param, AccountDO.class);
		t.setAccount(param.getPhone());
		t.setSalt(String.valueOf(new Random().nextInt(1000000)));
		t.setPassword(SysUtil.encryptedPassword("123456", t.getSalt()));
		this.accountMapper.insert(t);

		this.accountRoleMapper.insert(new AccountRoleDO(t.getId(), param.getRoleId()));

		List<Long> gridIds = param.getGridIds();
		if (!CollectionUtils.isEmpty(gridIds)) {
			List<GridAccountDO> list = new ArrayList<>(gridIds.size());
			for (Long gridId : gridIds) {
				list.add(new GridAccountDO(t.getId(), gridId));
			}
			this.gridAccountMapper.insertList(list);
		}
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
