package com.keqi.seed.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.seed.sys.domain.db.AccountRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountRoleMapper extends BaseMapper<AccountRoleDO> {

	int insertList(@Param("list") List<AccountRoleDO> list);

	int deleteByAccountId(Long accountId);
}