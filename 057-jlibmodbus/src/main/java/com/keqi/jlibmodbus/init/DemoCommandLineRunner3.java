package com.keqi.jlibmodbus.init;

import com.keqi.jlibmodbus.modbustcp.Zlan6844Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class DemoCommandLineRunner3 implements CommandLineRunner {

    @Override
    public void run(String... args) {

        Zlan6844 zlan6844 = new Zlan6844("127.0.0.1", 9091);

        // 通过定时任务线程池的方式开启定时任务
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            try {
                boolean[] coils = zlan6844.readCoils(Zlan6844Constant.DI1, 8);
                System.out.println(Arrays.toString(coils));

                coils = new boolean[8];
                zlan6844.writeMultipleCoils(Zlan6844Constant.DI1, coils);

            } catch (Throwable e) {
                log.error(e.getMessage(), e);
            }
        }, 1, 5, TimeUnit.SECONDS);
    }
}
