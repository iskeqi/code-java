
package com.keqi.springbootwebsocket.domain;


import java.util.Date;

/**
 * @ClassName DoorPointWebSocketHandler
 * @Author ZNYK-HYL
 * @Date 2019-07-12-10:20
 * @Version 1.0
 * @Description: websocket消息返回实体类
 */
public class WebSocketMessageEntity {

    /**
     * 消息返回类型msgType
     */
    private String msgType;
    /**
     * 消息推送时间
     */

    private Date msgTime;
    /**
     * 消息内容
     */
    private Object msgBody = "";

    public WebSocketMessageEntity() {
    }

    public WebSocketMessageEntity(String msgType, Object msgBody) {
        this.msgType = msgType;
        this.msgTime = new Date(System.currentTimeMillis());
        this.msgBody = msgBody;
    }

    public WebSocketMessageEntity(String msgType, Date msgTime, Object msgBody) {
        this.msgType = msgType;
        this.msgTime = msgTime;
        this.msgBody = msgBody;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    public Object getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(Object msgBody) {
        this.msgBody = msgBody;
    }
}
