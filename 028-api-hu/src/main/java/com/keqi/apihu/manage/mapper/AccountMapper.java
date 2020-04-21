package com.keqi.apihu.manage.mapper;

import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.domain.AccountListParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {

	int deleteByPrimaryKey(Long id);

	int insert(AccountDO record);

	int insertOrUpdate(AccountDO record);

	int insertOrUpdateSelective(AccountDO record);

	int insertSelective(AccountDO record);

	AccountDO selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(AccountDO record);

	int updateByPrimaryKey(AccountDO record);

	int updateBatch(List<AccountDO> list);

	int updateBatchSelective(List<AccountDO> list);

	int batchInsert(@Param("list") List<AccountDO> list);

	long count(AccountListParam accountListParam);

	List<AccountDO> listAccount(AccountListParam accountListParam);

	void batchDelete(@Param("ids") Long[] ids);

	AccountDO findOneByAccount(@Param("account") String account);

	void updatePasswordByAccount(@Param("account") String account, @Param("password") String password);
}