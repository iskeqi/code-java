package com.keqi.seed.sys.service.impl;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.provider.AbstractJdbcDataSourceProvider;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * DataSourceManager
 *
 * @author keqi
 */
@Slf4j
@Component
public class DataSourceManager {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private DefaultDataSourceCreator dataSourceCreator;

    @Value("${spring.datasource.dynamic.datasource.master.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.dynamic.datasource.master.url}")
    private String url;
    @Value("${spring.datasource.dynamic.datasource.master.username}")
    private String username;
    @Value("${spring.datasource.dynamic.datasource.master.password}")
    private String password;

    /**
     * 程序启动时，将已存在的数据源进行初始化
     *
     * @return r
     */
    @Bean
    public DynamicDataSourceProvider jdbcDynamicDataSourceProvider() {
        return new AbstractJdbcDataSourceProvider(driverClassName, url, username, password) {
            @Override
            protected Map<String, DataSourceProperty> executeStmt(Statement statement) throws SQLException {
                Map<String, DataSourceProperty> map = new HashMap<>();
                ResultSet rs = statement.executeQuery("select tenant_identifier from sys_tenant");
                while (rs.next()) {
                    String pollName = rs.getString("tenant_identifier");

                    DataSourceProperty property = new DataSourceProperty();
                    property.setUsername(username);
                    property.setPassword(password);
                    property.setUrl(replaceDatabaseName(url, pollName));
                    property.setDriverClassName(driverClassName);

                    map.put(pollName, property);
                }
                return map;
            }
        };
    }

    /**
     * 创建一个新的数据源
     *
     * @param pollName 连接池名称，需要保证唯一，建议使用租户唯一标识符进行命名
     */
    public synchronized void createDataSource(String pollName) {
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setPoolName(pollName);
        dataSourceProperty.setDriverClassName(driverClassName);
        dataSourceProperty.setUrl(replaceDatabaseName(url, pollName));
        dataSourceProperty.setUsername(username);
        dataSourceProperty.setPassword(password);

        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);
        ds.addDataSource(pollName, dataSource);
    }

    /**
     * 移除数据源
     *
     * @param pollName 连接池名称，需要保证唯一，建议使用租户唯一标识符进行命名
     */
    public synchronized void removeDataSource(String pollName) {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        ds.removeDataSource(pollName);
    }

    /**
     * 执行 resource 目录下的 sql 脚本文件
     *
     * @param pollName pollName
     * @return true 表示执行成功， false 表示执行失败
     */
    public boolean runSQLScriptFile(String pollName) {
        boolean result = true;
        Connection con = null;
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(replaceDatabaseName(url, pollName), username, password);
            ScriptRunner runner = new ScriptRunner(con);
            runner.setAutoCommit(false);
            runner.setStopOnError(true);
            runner.setSendFullScript(false);
            ClassPathResource resource = new ClassPathResource("tenant-schema.sql");
            runner.runScript(new InputStreamReader(resource.getInputStream()));
        } catch (Throwable e) {
            result = false;
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                log.error(ex.getMessage(), ex);
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return result;
    }

    private String replaceDatabaseName(String url, String pollName) {
        String dbName = url.substring(url.substring(0, url.indexOf("?")).lastIndexOf("/") + 1, url.indexOf("?"));
        return url.replace(dbName, pollName);
    }
}