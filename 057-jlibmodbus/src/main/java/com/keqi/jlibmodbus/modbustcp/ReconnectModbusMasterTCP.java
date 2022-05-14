package com.keqi.jlibmodbus.modbustcp;

import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ModbusTCP Master 断线重连
 *
 * @author keqi
 */
@Slf4j
@Lazy
@Component
public class ReconnectModbusMasterTCP {

    private final Map<String, AbstractModbusMasterTCP> MODBUS_MASTER_TCP_MAP = new HashMap<>();

    private ScheduledExecutorService executorService;

    @PostConstruct
    public void init() {
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            // 每隔 5 秒钟检测 ModbusTCP 连接是否断线，若断线，要主动重连
            MODBUS_MASTER_TCP_MAP.forEach((name, masterTCP) -> {
                if (!masterTCP.isConnected()) {
                    try {
                        masterTCP.connect();
                    } catch (ModbusIOException e) {
                        log.error("reconnect modbus slave device {} failure", name);
                    }
                }
            });
        }, 60, 5, TimeUnit.SECONDS);
    }

    public void addMaster(String name, AbstractModbusMasterTCP masterTCP) {
        MODBUS_MASTER_TCP_MAP.put(name, masterTCP);
    }

    public void removeMaster(String name, AbstractModbusMasterTCP masterTCP) {
        MODBUS_MASTER_TCP_MAP.remove(name);
    }
}
