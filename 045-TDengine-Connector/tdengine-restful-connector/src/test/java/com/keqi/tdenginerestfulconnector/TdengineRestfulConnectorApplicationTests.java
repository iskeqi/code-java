package com.keqi.tdenginerestfulconnector;

import com.taosdata.jdbc.TSDBConnection;
import com.taosdata.jdbc.TSDBResultSet;
import com.taosdata.jdbc.TSDBSubscribe;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.OperationsException;
import java.sql.*;

@SpringBootTest
class TdengineRestfulConnectorApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1() throws ClassNotFoundException, SQLException {
        Class.forName("com.taosdata.jdbc.rs.RestfulDriver");
        String jdbcUrl = "jdbc:TAOS-RS://124.70.163.117:6041/test?user=root&password=taosdata";
        Connection conn = DriverManager.getConnection(jdbcUrl);

        Statement stmt = conn.createStatement();
        // 如果不显示执行 "use test" 命令，则后续对表的操作都需要指定库名
        stmt.executeUpdate("use test");

        // 对表的增删改，插入数据等都是通过此方法，直接构造sql语句即可
        // int i = stmt.executeUpdate();

        // select last_row(ts, f1, f2, f3) from t1;
        ResultSet resultSet = stmt.executeQuery("select last_row(ts, f1, f2, f3) from t1;");
        while (resultSet.next()) {
            Timestamp ts = resultSet.getTimestamp(1);
            int f1 = resultSet.getInt(2);
            int f2 = resultSet.getInt(3);
            int f3 = resultSet.getInt(4);

            System.out.println("===============");
            System.out.println(ts + " " + f1 + " " + f2 + " " + f3);
            System.out.println("===============");
        }

        resultSet.close();
        stmt.close();
        conn.close();
    }


    // 测试失败了
    @Test
    void test2() throws ClassNotFoundException, SQLException, OperationsException, InterruptedException {
        /*Class.forName("com.taosdata.jdbc.rs.RestfulDriver");
        String jdbcUrl = "jdbc:TAOS-RS://124.70.163.117:6041/test?user=root&password=taosdata";*/
        Class.forName("com.taosdata.jdbc.TSDBDriver");
        String jdbcUrl = "jdbc:TAOS://124.70.163.117:6030/test?user=root&password=taosdata";
        TSDBConnection conn = (TSDBConnection) DriverManager.getConnection(jdbcUrl);

        /*Statement stmt = conn.createStatement();
        // 如果不显示执行 "use test" 命令，则后续对表的操作都需要指定库名
        stmt.executeUpdate("use test");*/

        // 采用主动拉取的方式获取数据，但是时间戳已经由驱动内部解决了，无需使用者关心
        TSDBSubscribe sub = conn.subscribe("topic2", "select * from test.meters", true);
        int count = 0;
        while (count < 1000) {
            TSDBResultSet rs = sub.consume();
            while (rs.next()) {
                Timestamp ts = rs.getTimestamp(1);
                int f1 = rs.getInt(2);
                int f2 = rs.getInt(3);
                int f3 = rs.getInt(4);

                System.out.println("====" + ts + " " + f1 + " " + f2 + " " + f3);
            }
            Thread.sleep(1000);
            count++;
            rs.close();
        }

        sub.close(false);
        conn.close();
    }

    @Test
    void test3() throws SQLException {

        HikariConfig config = new HikariConfig();
        // jdbc properties
        config.setJdbcUrl("jdbc:TAOS://124.70.163.117:6030/test");
        config.setUsername("root");
        config.setPassword("taosdata");
        // connection pool configurations
        config.setMinimumIdle(10);           //minimum number of idle connection
        config.setMaximumPoolSize(10);      //maximum number of connection in the pool
        config.setConnectionTimeout(30000); //maximum wait milliseconds for get connection from pool
        config.setMaxLifetime(0);       // maximum life time for each connection
        config.setIdleTimeout(0);       // max idle time for recycle idle connection
        config.setConnectionTestQuery("select server_status()"); //validation query
        HikariDataSource ds = new HikariDataSource(config); //create datasource
        Connection  connection = ds.getConnection(); // get connection
        Statement statement = connection.createStatement(); // get statement
        //query or insert
        // ...
        connection.close(); // put back to conneciton pool
    }
}
