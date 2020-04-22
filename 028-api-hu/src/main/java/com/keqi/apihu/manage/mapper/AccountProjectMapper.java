package com.keqi.apihu.manage.mapper;

import com.keqi.apihu.manage.domain.AccountProjectDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountProjectMapper {

	int deleteByPrimaryKey(@Param("accountId") Long accountId, @Param("projectId") Long projectId);

	int insert(AccountProjectDO record);

	int insertSelective(AccountProjectDO record);

	int batchInsert(@Param("list") List<AccountProjectDO> list);

	int deleteByProjectId(@Param("projectId")Long projectId);


}