package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.AccountRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountRoleMapper extends BaseMapper<AccountRoleDO> {

	int insertList(@Param("list") List<AccountRoleDO> list);

	int deleteByAccountId(Long accountId);
}