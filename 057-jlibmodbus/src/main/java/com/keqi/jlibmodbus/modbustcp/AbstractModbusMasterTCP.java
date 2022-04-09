package com.keqi.jlibmodbus.modbustcp;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusProtocolException;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * 继承此类即可拥有使用 ModbusTCP 协议与硬件设备通信的能力
 *
 * @author keqi
 */
@Slf4j
public abstract class AbstractModbusMasterTCP {

    private ModbusMaster modbusMaster;
    private static final int serverAddress = 1;

    protected String host;
    protected int port;
    protected String deviceName;

    protected String errorMsg = "ModbusTCP slave [deviceName] occurs exception ";

    public AbstractModbusMasterTCP(String host, int port, String deviceName) throws ModbusTCPException {
        try {
            this.deviceName = deviceName == null ? host + ":" + port : deviceName;
            this.host = host;
            this.port = port;

            errorMsg.replace("deviceName", this.deviceName);

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
            handleException(e);
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
            handleException(e);
        }
        return null;
    }

    /**
     * 读单个线圈
     *
     * @param startAddress startAddress
     * @return r
     * @throws ModbusTCPException e
     */
    final public boolean readCoils(int startAddress) throws ModbusTCPException {
        return Objects.requireNonNull(readCoils(startAddress, 1))[0];
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
            handleException(e);
        }
        return null;
    }

    /**
     * 读单个保持寄存器
     *
     * @param startAddress startAddress
     * @return r
     * @throws ModbusTCPException e
     */
    final public int readHoldingRegisters(int startAddress) throws ModbusTCPException {
        return Objects.requireNonNull(readHoldingRegisters(startAddress, 1))[0];
    }

    /**
     * 读离散寄存器
     *
     * @param startAddress startAddress
     * @param quantity     quantity
     * @return r
     * @throws ModbusTCPException e
     */
    final public boolean[] readDiscreteInputs(int startAddress, int quantity) throws ModbusTCPException {
        try {
            return modbusMaster.readDiscreteInputs(serverAddress, startAddress, quantity);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            handleException(e);
        }
        return null;
    }

    /**
     * 读单个离散寄存器
     *
     * @param startAddress startAddress
     * @return r
     * @throws ModbusTCPException e
     */
    final public boolean readDiscreteInputs(int startAddress) throws ModbusTCPException {
        return Objects.requireNonNull(readDiscreteInputs(startAddress, 1))[0];
    }

    /**
     * 读输入寄存器
     *
     * @param startAddress startAddress
     * @param quantity     quantity
     * @return r
     * @throws ModbusTCPException e
     */
    final public int[] readInputRegisters(int startAddress, int quantity) throws ModbusTCPException {
        try {
            return modbusMaster.readInputRegisters(serverAddress, startAddress, quantity);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            handleException(e);
        }
        return null;
    }

    /**
     * 读单个输入寄存器
     *
     * @param startAddress startAddress
     * @return r
     * @throws ModbusTCPException e
     */
    final public int readInputRegisters(int startAddress) throws ModbusTCPException {
        return Objects.requireNonNull(readInputRegisters(startAddress, 1))[0];
    }

    /**
     * 写单个线圈
     *
     * @param startAddress startAddress
     * @param coil         coil
     * @throws ModbusTCPException e
     */
    final public void writeSingleCoil(int startAddress, boolean coil) throws ModbusTCPException {
        try {
            modbusMaster.writeSingleCoil(serverAddress, startAddress, coil);
        } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
            handleException(e);
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
            handleException(e);
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
            handleException(e);
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
            handleException(e);
        }
    }

    private void handleException(Throwable e) {
        // 断线重连功能需要重新设计
        /*if (e instanceof ModbusIOException) {
            if (!this.modbusMaster.isConnected()) {
                try {
                    // 尝试重连
                    this.modbusMaster.connect();
                } catch (ModbusIOException ex) {
                    // 重连失败，直接抛异常，中断当前调用链
                    throw new ModbusTCPException(errorMsg, e);
                }
                // 重连成功，不中断当前调用链(最好在这里进行重试，而不是通过返回值去重试，可能造成死循环)
                return true;
            }
        }*/
        throw new ModbusTCPException(errorMsg, e);
    }
}
