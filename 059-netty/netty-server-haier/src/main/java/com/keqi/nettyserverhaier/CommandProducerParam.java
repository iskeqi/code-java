package com.keqi.nettyserverhaier;

/**
 * 请求上位机控制 plc 请求实体类（中控 -> 上位机）
 *
 * @author keqi
 */
public class CommandProducerParam {

    /**
     * Request id (Simple UUID)
     */
    private String Id;

    /**
     * 指令名称
     */
    private String Command;

    /**
     * 指令动作
     */
    private String Type;

    /**
     * 需转动的滚杠线
     */
    private String Station;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStation() {
        return Station;
    }

    public void setStation(String station) {
        Station = station;
    }
}
