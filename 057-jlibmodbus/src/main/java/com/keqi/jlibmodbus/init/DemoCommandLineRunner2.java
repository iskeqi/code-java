package com.keqi.jlibmodbus.init;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class DemoCommandLineRunner2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // 通过定时任务线程池的方式开启定时任务
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            try {
                TcpParameters tcpParameters = new TcpParameters();
                InetAddress address = InetAddress.getByName("127.0.0.1");
                tcpParameters.setHost(address);
                tcpParameters.setKeepAlive(true);
                tcpParameters.setPort(Modbus.TCP_PORT);

                ModbusMaster master = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);
                Modbus.setAutoIncrementTransactionId(true);

                // 如果有多个 slave 设备呢？直接在内存中维护多个 ModbusMaster 对象吗？还是 ModbusSlave 对象
                // 当然是 ModbusMaster 对象啦
                // ModbusSlave slave = ModbusSlaveFactory.createModbusSlaveTCP(tcpParameters);

                if (!master.isConnected()) {
                    master.connect();
                }

                int slaveId = 1;//从机地址
                int offset = 0;//寄存器读取开始地址
                int quantity = 10;//读取的寄存器数量

                // 读取线圈寄存器
                System.out.println("==================");

                    /*boolean[] coils = master.readCoils(slaveId, offset, quantity);
                    System.out.println(Arrays.toString(coils));*/

                // 读取离散寄存器
                    /*boolean[] discreteInputs = master.readDiscreteInputs(slaveId, offset, quantity);
                    System.out.println(Arrays.toString(discreteInputs));*/

                // 读取保持寄存器
                int[] holdingRegisters = master.readHoldingRegisters(slaveId, offset, quantity);
                System.out.println(Arrays.toString(holdingRegisters));

                // 读取输入寄存器
                    /*int[] inputRegisters = master.readInputRegisters(slaveId, offset, quantity);
                    System.out.println(Arrays.toString(inputRegisters));*/

                // 写单个线圈寄存器
                // master.writeSingleCoil();

                // 写多个线圈寄存器
                // master.writeMultipleCoils();

                // 写单个保持寄存器
                // master.writeSingleRegister();

                // 写多个保持寄存器
                // master.writeMultipleRegisters();

                System.out.println("==================");
            } catch (Throwable e) {
                log.error(e.getMessage());
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
