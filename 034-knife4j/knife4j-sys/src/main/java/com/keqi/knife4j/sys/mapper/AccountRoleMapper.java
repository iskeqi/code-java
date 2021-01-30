package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.AccountRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountRoleMapper extends BaseMapper<AccountRoleDO> {

	/**
	 * 根据 accountId 删除关联关系
	 *
	 * @param accountId accountId
	 * @return r
	 */
	int deleteByAccountId(@Param("accountId") Long accountId);

	/**
	 * 批量新增
	 *
	 * @param list list
	 * @return r
	 */
	int insertList(@Param("list") List<AccountRoleDO> list);


}