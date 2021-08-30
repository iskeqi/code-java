package com.keqi.seed.sys.service.impl;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
     * 创建一个新的数据源
     *
     * @param pollName 连接池名称，需要保证唯一，建议使用租户唯一标识符进行命名
     */
    public synchronized void createDataSource(String pollName) {
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setPoolName(pollName);
        dataSourceProperty.setDriverClassName(driverClassName);
        String dbName = url.substring(url.substring(0, url.indexOf("?")).lastIndexOf("/") + 1, url.indexOf("?"));
        dataSourceProperty.setUrl(url.replace(dbName, pollName));
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
    public synchronized void removeDataSource(String pollName) {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        ds.removeDataSource(pollName);
    }

    /**
     * 创建数据库
     *
     * @param databaseName databaseName
     */
    public void createDatabase(String databaseName) {
        String sql = "create database " + databaseName;
        execute(sql);
    }

    /**
     * 删除数据库
     *
     * @param databaseName databaseName
     */
    public void dropDatabase(String databaseName) {
        String sql = "drop database " + databaseName;
        execute(sql);
    }

    /**
     * 执行 resource 目录下的 sql 脚本文件
     *
     * @param pollName pollName
     */
    public void runSQLScriptFile(String pollName) {
        Connection con = null;
        try {
            Class.forName(driverClassName);
            String dbName = url.substring(url.substring(0, url.indexOf("?")).lastIndexOf("/") + 1, url.indexOf("?"));
            con = DriverManager.getConnection(url.replace(dbName, pollName), username, password);
            ScriptRunner runner = new ScriptRunner(con);
            runner.setAutoCommit(false);
            runner.setStopOnError(true);
            runner.setSendFullScript(false);
            ClassPathResource resource = new ClassPathResource("tenant-schema.sql");
            runner.runScript(new InputStreamReader(resource.getInputStream()));
        } catch (Throwable e) {
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
    }

    @SneakyThrows
    private void execute(String sql) {
        PreparedStatement pst = null;
        Connection con = null;
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, username, password);
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}