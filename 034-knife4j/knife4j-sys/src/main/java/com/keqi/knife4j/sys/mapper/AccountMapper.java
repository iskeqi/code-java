package com.keqi.knife4j.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.knife4j.sys.domain.db.AccountDO;
import com.keqi.knife4j.sys.domain.param.AccountPageParam;
import com.keqi.knife4j.sys.domain.vo.AccountVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper extends BaseMapper<AccountDO> {

	int updatePasswordById(@Param("password") String password, @Param("id") Long id);

	List<AccountVO> page(AccountPageParam pageParam);

	AccountDO selectByAccount(String account);
}