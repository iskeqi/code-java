package com.keqi.jlibmodbus.modbustcp;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusProtocolException;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 继承此类即可拥有使用 ModbusTCP 协议与硬件设备通信的能力
 *
 * @author keqi
 */
public abstract class AbstractModbusMasterTCP {

    private final ModbusMaster modbusMaster;
    private final int serverAddress = 1;

    public AbstractModbusMasterTCP(String host, int port) throws ModbusTCPException {
        try {
            TcpParameters tcpParameters = new TcpParameters();
            tcpParameters.setHost(InetAddress.getByName(host));
            tcpParameters.setKeepAlive(true);
            tcpParameters.setPort(port);

            modbusMaster = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);

            Modbus.setAutoIncrementTransactionId(true);

            if (!modbusMaster.isConnected()) {
                modbusMaster.connect();
            }
        } catch (UnknownHostException | ModbusIOException e) {
            throw new ModbusTCPException(e.getMessage(), e);
        }
    }

    /**
     * 读线圈
     *
     * @param startAddress startAddress
     * @param quantity     quantity
     * @return r
     * @throws ModbusTCPException e
     */
    final public boolean[] readCoils(int startAddress, int quantity) throws ModbusTCPException {
        try {
            return modbusMaster.readCoils(serverAddress, startAddress, quantity);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            throw new ModbusTCPException(e.getMessage(), e);
        }
    }

    /**
     * 写单个线圈
     *
     * @param startAddress startAddress
     * @param flag         flag
     * @throws ModbusTCPException e
     */
    final public void writeSingleCoil(int startAddress, boolean flag) throws ModbusTCPException {
        try {
            modbusMaster.writeSingleCoil(serverAddress, startAddress, flag);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            throw new ModbusTCPException(e.getMessage(), e);
        }
    }

    /**
     * 写多个线圈
     *
     * @param startAddress startAddress
     * @param coils        coils
     * @throws ModbusTCPException e
     */
    final public void writeMultipleCoils(int startAddress, boolean[] coils) throws ModbusTCPException {
        try {
            modbusMaster.writeMultipleCoils(serverAddress, startAddress, coils);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            throw new ModbusTCPException(e.getMessage(), e);
        }
    }

    /**
     * 读保持寄存器
     *
     * @param startAddress startAddress
     * @param quantity     quantity
     * @return r
     * @throws ModbusTCPException e
     */
    final public int[] readHoldingRegisters(int startAddress, int quantity) throws ModbusTCPException {
        try {
            return modbusMaster.readHoldingRegisters(serverAddress, startAddress, quantity);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            throw new ModbusTCPException(e.getMessage(), e);
        }
    }

    /**
     * 写单个保持寄存器
     *
     * @param startAddress startAddress
     * @param register     register
     * @throws ModbusTCPException e
     */
    final public void writeSingleRegister(int startAddress, int register) throws ModbusTCPException {
        try {
            modbusMaster.writeSingleRegister(serverAddress, startAddress, register);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            throw new ModbusTCPException(e.getMessage(), e);
        }
    }

    /**
     * 写多个保持寄存器
     *
     * @param startAddress startAddress
     * @param registers    registers
     * @throws ModbusTCPException e
     */
    final public void writeMultipleRegisters(int startAddress, int[] registers) throws ModbusTCPException {
        try {
            modbusMaster.writeMultipleRegisters(serverAddress, startAddress, registers);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            throw new ModbusTCPException(e.getMessage(), e);
        }
    }
}
