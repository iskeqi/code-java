package com.keqi.mybatisplusagain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.keqi.mybatisplusagain.domain.Account;
import com.keqi.mybatisplusagain.domain.PageParam;

public interface AccountMapper extends BaseMapper<Account> {

	IPage<Account> page(PageParam pageParam);
}