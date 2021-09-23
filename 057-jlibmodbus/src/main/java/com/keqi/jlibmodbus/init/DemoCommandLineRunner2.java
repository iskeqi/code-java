package com.keqi.jlibmodbus.init;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
/*@Component*/
public class DemoCommandLineRunner2 implements CommandLineRunner {

    private final Object obj = new Object();

    @Override
    public void run(String... args) throws Exception {
        // 通过定时任务线程池的方式开启定时任务
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        Map<String, ModbusMaster> modbusMasterMap = new HashMap<>();

        TcpParameters tcpParameters1 = new TcpParameters();
        tcpParameters1.setHost(InetAddress.getByName("127.0.0.1"));
        tcpParameters1.setKeepAlive(true);
        tcpParameters1.setPort(9090);
        ModbusMaster master1 = ModbusMasterFactory.createModbusMasterTCP(tcpParameters1);
        Modbus.setAutoIncrementTransactionId(true);

        TcpParameters tcpParameters2 = new TcpParameters();
        tcpParameters2.setHost(InetAddress.getByName("127.0.0.1"));
        tcpParameters2.setKeepAlive(true);
        tcpParameters2.setPort(9091);
        ModbusMaster master2 = ModbusMasterFactory.createModbusMasterTCP(tcpParameters2);
        Modbus.setAutoIncrementTransactionId(true);

        modbusMasterMap.put("127.0.0.1:9090", master1);
        modbusMasterMap.put("127.0.0.1:9091", master2);

        for (Map.Entry<String, ModbusMaster> entry : modbusMasterMap.entrySet()) {
            ModbusMaster master = entry.getValue();
            if (!master.isConnected()) {
                master.connect();
            }
        }

        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            try {
                synchronized (obj) {
                    // 如果有多个 slave 设备呢？直接在内存中维护多个 ModbusMaster 对象吗？还是 ModbusSlave 对象
                    // 当然是 ModbusMaster 对象啦
                    // ModbusSlave slave = ModbusSlaveFactory.createModbusSlaveTCP(tcpParameters);

                    for (Map.Entry<String, ModbusMaster> entry : modbusMasterMap.entrySet()) {
                        ModbusMaster master = entry.getValue();

                        int slaveId = 1;//从机地址
                        int offset = 0;//寄存器读取开始地址
                        int quantity = 10;//读取的寄存器数量

                        // 读取线圈寄存器
                        boolean[] coils = master.readCoils(slaveId, offset, quantity);
                        System.out.println(Arrays.toString(coils) + " ->" + entry.getKey());

                        // 读取离散寄存器
                        boolean[] discreteInputs = master.readDiscreteInputs(slaveId, offset, quantity);
                        System.out.println(Arrays.toString(discreteInputs) + " ->" + entry.getKey());

                        // 读取保持寄存器
                        int[] holdingRegisters = master.readHoldingRegisters(slaveId, offset, quantity);
                        System.out.println(Arrays.toString(holdingRegisters) + " ->" + entry.getKey());

                        // 读取输入寄存器
                        int[] inputRegisters = master.readInputRegisters(slaveId, offset, quantity);
                        System.out.println(Arrays.toString(inputRegisters) + " ->" + entry.getKey());

                        // 写单个线圈寄存器
                        for (int i = 0; i < 10; i++) {
                            master.writeSingleCoil(slaveId, i, false);
                        }

                        // 写多个线圈寄存器
                        master.writeMultipleCoils(slaveId, offset, new boolean[]{true, true, true, true, true, true, true, true, true, true});

                        // 写单个保持寄存器
                        for (int i = 0; i < 10; i++) {
                            master.writeSingleRegister(slaveId, i, 100);
                        }

                        // 写多个保持寄存器
                        master.writeMultipleRegisters(slaveId, offset, holdingRegisters);
                    }
                    System.out.println("----------------->");
                }
            } catch (Throwable e) {
                log.error(e.getMessage());
            }
        }, 1, 5, TimeUnit.SECONDS);
    }
}
