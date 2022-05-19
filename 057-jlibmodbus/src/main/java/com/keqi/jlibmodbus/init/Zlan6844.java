package com.keqi.jlibmodbus.init;

import com.keqi.jlibmodbus.modbustcp.AbstractModbusMasterTCP;
import com.keqi.jlibmodbus.modbustcp.ModbusTCPException;
import com.keqi.jlibmodbus.modbustcp.Zlan6844Constant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Zlan6844 extends AbstractModbusMasterTCP {

    public Zlan6844(String host, int port) throws ModbusTCPException {
        super(host, port, null);
    }

    // 可以根据自己的需求制定
    public void fun() {
        log.info("DI1 {}", readCoils(Zlan6844Constant.DI1));
    }
}
