package com.keqi.nettyserverhaier;

/**
 * 上位机请求实体类（上位机 -> 中控）
 *
 * @author keqi
 */
public class CommandConsumerParam {

    /**
     * Request id (Simple UUID)
     */
    private String Id;

    /**
     * 指令名称
     */
    private String Command;

    /**
     * 起点
     */
    private String StartingPoint;

    /**
     * 终点
     */
    private String EndPoint;

    /**
     * 站点类型
     */
    private String Station;

    /**
     * 上位机对应的数字编号
     */
    private Integer client;

    /**
     * 地图 id
     */
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
