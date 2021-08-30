package com.keqi.seed.sys.service;

import com.keqi.seed.core.pojo.BaseService;
import com.keqi.seed.sys.domain.db.TenantDO;
import com.keqi.seed.sys.mapper.TenantMapper;
import com.keqi.seed.sys.service.impl.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TenantService implements BaseService<TenantDO> {

    @Autowired
    private TenantMapper tenantMapper;
    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    @Override
    public TenantDO insert(TenantDO tenantDO) {
        tenantMapper.insert(tenantDO);
        // 新增租户对应的DB
        dataSourceManager.createDatabase(tenantDO.getTenantIdentifier());
        // 增加新的数据源
        dataSourceManager.createDataSource(tenantDO.getTenantIdentifier());
        // 执行 tenant-schema.sql 脚本
        dataSourceManager.runSQLScriptFile(tenantDO.getTenantIdentifier());
        return tenantDO;
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        TenantDO tenantDO = tenantMapper.selectById(id);
        // 删除对应的库
        dataSourceManager.dropDatabase(tenantDO.getTenantIdentifier());
        // 断开对应的数据源
        dataSourceManager.removeDataSource(tenantDO.getTenantIdentifier());
        tenantMapper.deleteById(id);
    }

    @Override
    public void updateById(TenantDO tenantDO) {
        tenantMapper.updateById(tenantDO);
    }

    @Override
    public TenantDO getById(String id) {
        return tenantMapper.selectById(id);
    }


}
