package com.keqi.seed.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.keqi.seed.sys.domain.db.AccountDO;
import com.keqi.seed.sys.domain.param.AccountPageParam;

public interface AccountMapper extends BaseMapper<AccountDO> {
    IPage<AccountDO> page(AccountPageParam param);
}