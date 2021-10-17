package com.keqi.jlibmodbus.init;

import com.keqi.jlibmodbus.modbustcp.AbstractModbusMasterTCP;
import com.keqi.jlibmodbus.modbustcp.ModbusTCPException;

public class Zlan6844 extends AbstractModbusMasterTCP {

    public Zlan6844(String host, int port) throws ModbusTCPException {
        super(host, port);
    }

    // 可以根据自己的需求制定
    public void fun() {
        System.out.println(this.host + " " + this.port);
    }
}
