package com.keqi.springbootwebsocket.strategy;

import com.keqi.springbootwebsocket.constants.WebSocketCode;
import com.keqi.springbootwebsocket.domain.WebSocketMessageEntity;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 负责车闸地图信息
 *
 * @author keqi
 */
@Component
public class BrakeStrategyImpl implements WebSocketStrategy {

    /**
     * 每个处理器返回自己能处理的msgCode
     */
    @Override
    public List<WebSocketCode> getMsgCode() {
        List<WebSocketCode> codeList = new ArrayList<>();
        codeList.add(WebSocketCode.INMONITORING_CAR_BRAKE_F1);
        codeList.add(WebSocketCode.INMONITORING_CAR_BRAKE_B1);
        codeList.add(WebSocketCode.INMONITORING_CAR_BRAKE_B2);
        return codeList;
    }

    private static String getMsgTypeByMsgCode(String msgCode) {
        String msgType = null;
        if(msgCode==null){
            return null;
        }
        if (msgCode.equals(WebSocketCode.INMONITORING_CAR_BRAKE_F1.getMsgCode())){
            msgType = WebSocketCode.INMONITORING_CAR_BRAKE_F1.getMsgType();
        }else if (msgCode.equals(WebSocketCode.INMONITORING_CAR_BRAKE_B1.getMsgCode())){
            msgType = WebSocketCode.INMONITORING_CAR_BRAKE_B1.getMsgType();
        }else if (msgCode.equals(WebSocketCode.INMONITORING_CAR_BRAKE_B2.getMsgCode())){
            msgType = WebSocketCode.INMONITORING_CAR_BRAKE_B2.getMsgType();
        }
        return msgType;
    }

    /**
     * 单个客户端页面发生改变时业务数据全量数据推送
     * msgCode决定是否发送 不处理可直接return
     *
     * @param msgCode
     */
    @Override
    public List<WebSocketMessageEntity> getAllResponseData(String msgCode) {
        List<WebSocketMessageEntity> responseList = new ArrayList<>();

        System.out.println("开始睡眠" + System.currentTimeMillis());
        System.out.println("BrakeHandler_线程" + Thread.currentThread().getId());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束睡眠" + System.currentTimeMillis());


        WebSocketMessageEntity w1 = new WebSocketMessageEntity();
        w1.setMsgTime(new Date());
        w1.setMsgType(getMsgTypeByMsgCode(msgCode));
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name","keqi");
        map1.put("age", 23);
        w1.setMsgBody(map1);
        responseList.add(w1);

        WebSocketMessageEntity w2 = new WebSocketMessageEntity();
        w2.setMsgTime(new Date());
        w2.setMsgType(getMsgTypeByMsgCode(msgCode));
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name","keqi");
        map2.put("age", 23);
        w2.setMsgBody(map1);
        responseList.add(w2);

        return responseList;
    }
}
