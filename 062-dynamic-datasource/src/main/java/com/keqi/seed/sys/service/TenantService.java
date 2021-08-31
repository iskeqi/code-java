package com.keqi.seed.sys.service;

import com.keqi.seed.core.exception.BusinessException;
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

    @Override
    public TenantDO insert(TenantDO tenantDO) {
        String tenantIdentifier = tenantDO.getTenantIdentifier();

        // todo 待重构，切换成责任链模式

        boolean result1 = true;
        try {
            // 新增租户记录
            tenantMapper.insert(tenantDO);
        } catch (Throwable e) {
            result1 = false;
        }

        boolean result2 = true;
        if (result1) {
            try {
                // 创建租户对应的 db
                tenantMapper.createDatabase(tenantIdentifier);
            } catch (Throwable e) {
                result2 = false;
            }
        }

        boolean result3 = true;
        if (result1 && result2) {
            // 在新的数据库中执行 sql 脚本
            result3 = dataSourceManager.runSQLScriptFile(tenantIdentifier);
        }

        boolean result4 = true;
        if (result1 && result2 && result3) {
            try {
                dataSourceManager.createDataSource(tenantIdentifier);
            } catch (Throwable e) {
                result4 = false;
            }
        }

        // 手动进行回滚
        if (!result1 || !result2 || !result3 || !result4) {
            if (!result4) {
                dataSourceManager.removeDataSource(tenantIdentifier);
            }
            if (!result2) {
                tenantMapper.dropDatabase(tenantIdentifier);
            }
            if (!result1) {
                tenantMapper.deleteById(tenantDO.getId());
            }
            throw new BusinessException("租户创建失败，请稍后重试");
        }

        return tenantDO;
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        TenantDO tenantDO = tenantMapper.selectById(id);
        // 实际开发中，应该在这里进行逻辑删除，然后利用定时任务异步进行永久删除
        // 断开对应的数据源
        dataSourceManager.removeDataSource(tenantDO.getTenantIdentifier());
        // 删除对应的库
        tenantMapper.dropDatabase(tenantDO.getTenantIdentifier());
        // 删除对应的租户记录
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
