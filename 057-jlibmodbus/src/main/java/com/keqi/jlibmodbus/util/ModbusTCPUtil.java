package com.keqi.jlibmodbus.util;

public class ModbusTCPUtil {

    // 读取线圈寄存器
    boolean[] readCoils(int slaveId, int offset, int quantity) {
        return null;
    }

    // 读取离散寄存器
    boolean[] readDiscreteInputs(int slaveId, int offset, int quantity) {
        return null;
    }

    // 读取保持寄存器
    int[] readHoldingRegisters(int slaveId, int offset, int quantity) {
        return null;
    }

    // 读取输入寄存器
    int[] readInputRegisters(int slaveId, int offset, int quantity) {
        return null;
    }

    // 写单个线圈寄存器
    void writeSingleCoil(int slaveId, int offset, int quantity) {

    }

    // 写多个线圈寄存器
    void writeMultipleCoils(int slaveId, int offset, boolean[] bools) {

    }

    // 写单个保持寄存器
    void writeSingleRegister(int slaveId, int offset, int quantity) {
    }

    // 写多个保持寄存器
    void writeMultipleRegisters(int slaveId, int offset, int quantity) {

    }
}
