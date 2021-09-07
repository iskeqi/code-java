package com.keqi.nettyserverhaier;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 上位机请求实体类（上位机 -> 中控）
 *
 * @author keqi
 */
public class CommandConsumerParam {

    /**
     * Request id (Simple UUID)
     */
    @JSONField(name = "Id")
    private String Id;

    /**
     * 指令名称
     */
    @JSONField(name = "Command")
    private String Command;

    /**
     * 起点
     */
    @JSONField(name = "StartingPoint")
    private String StartingPoint;

    /**
     * 终点
     */
    @JSONField(name = "EndPoint")
    private String EndPoint;

    /**
     * 站点类型
     */
    @JSONField(name = "Station")
    private String Station;

    /**
     * 上位机对应的数字编号
     */
    @JSONField(name = "client")
    private Integer client;

    /**
     * 地图 id
     */
    @JSONField(name = "mapId")
    private Integer mapId;

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

    public String getStartingPoint() {
        return StartingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        StartingPoint = startingPoint;
    }

    public String getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public String getStation() {
        return Station;
    }

    public void setStation(String station) {
        Station = station;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }
}
