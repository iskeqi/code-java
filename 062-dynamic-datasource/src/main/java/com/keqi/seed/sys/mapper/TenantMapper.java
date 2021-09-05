package com.keqi.seed.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.seed.sys.domain.db.TenantDO;

public interface TenantMapper extends BaseMapper<TenantDO> {

    void createDatabase(String databaseName);

    void dropDatabase(String databaseName);
}