package com.keqi.jlibmodbus;

import com.keqi.jlibmodbus.init.Zlan6844;
import com.keqi.jlibmodbus.modbustcp.ReconnectModbusMasterTCP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
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
        ReconnectModbusMasterTCP reconnectModbusMasterTCP = applicationContext.getBean(ReconnectModbusMasterTCP.class);

        // 如果此时连接建立失败，会抛异常
        Zlan6844 zlan6844 = new Zlan6844("127.0.0.1", 502);

        reconnectModbusMasterTCP.addMaster("door1", zlan6844);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            try {
                zlan6844.fun();
            } catch (Throwable e) {
                log.error(e.getMessage());
            }
        }, 0, 3, TimeUnit.SECONDS);
    }

}
