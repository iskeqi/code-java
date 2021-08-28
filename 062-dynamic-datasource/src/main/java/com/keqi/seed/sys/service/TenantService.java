package com.keqi.seed.sys.service;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.keqi.seed.core.pojo.BaseService;
import com.keqi.seed.sys.domain.db.TenantDO;
import com.keqi.seed.sys.mapper.TenantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class TenantService implements BaseService<TenantDO> {

    @Autowired
    private TenantMapper tenantMapper;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DefaultDataSourceCreator dataSourceCreator;

    @Override
    public TenantDO insert(TenantDO tenantDO) {
        tenantMapper.insert(tenantDO);
        // 新增租户对应的DB
        // 进行 schema.sql 和 data.sql 的数据初始化
        // 新增新的数据源

        return tenantDO;
    }

    @Override
    public void deleteById(String id) {
        // 删除对应的库
        // 断开对应的数据源
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

    /**
     * 创建一个新的数据源
     *
     * @param pollName        连接池名称，需要保证唯一，建议使用租户唯一标识符进行命名
     * @param driverClassName 驱动名称
     * @param url             数据库连接 url
     * @param username        用户名
     * @param password        密码
     */
    private synchronized void createDataSource(String pollName, String driverClassName,
                                               String url, String username, String password) {
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setPoolName(pollName);
        dataSourceProperty.setDriverClassName(driverClassName);
        dataSourceProperty.setUrl(url);
        dataSourceProperty.setUsername(username);
        dataSourceProperty.setPassword(password);

        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        ds.addDataSource(pollName, dataSource);
    }

    /**
     * 移除数据源
     *
     * @param pollName 连接池名称，需要保证唯一，建议使用租户唯一标识符进行命名
     */
    private synchronized void removeDataSource(String pollName) {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        ds.removeDataSource(pollName);
    }
}
