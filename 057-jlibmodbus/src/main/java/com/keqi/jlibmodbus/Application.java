package com.keqi.jlibmodbus;

import com.keqi.jlibmodbus.modbustcp.ReconnectModbusMasterTCP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {


    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        Application.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // 测试懒加载对象
        applicationContext.getBean(ReconnectModbusMasterTCP.class);
    }

}
