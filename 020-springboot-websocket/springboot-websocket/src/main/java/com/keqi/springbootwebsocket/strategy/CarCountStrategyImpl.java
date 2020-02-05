package com.keqi.springbootwebsocket.strategy;


import com.keqi.springbootwebsocket.constants.WebSocketCode;
import com.keqi.springbootwebsocket.domain.WebSocketMessageEntity;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 负责推送停车数量查询
 *
 * @author keqi
 */
@Component
public class CarCountStrategyImpl implements WebSocketStrategy {

    /**
     * 每个处理器返回自己能处理的msgCode
     */
    @Override
    public List<WebSocketCode> getMsgCode() {
        List<WebSocketCode> codeList = new ArrayList<>();
        codeList.add(WebSocketCode.INMONITORING_CAR_COUNT);
        return codeList;
    }

    @Override
    public List<WebSocketMessageEntity> getAllResponseData(String msgCode) {

        System.out.println("开始睡眠" + System.currentTimeMillis());
        System.out.println("CarCountHandler_线程" + Thread.currentThread().getId());
        System.out.println("结束睡眠" + System.currentTimeMillis());
        List<WebSocketMessageEntity> responseList = new ArrayList<>();

        WebSocketMessageEntity w1 = new WebSocketMessageEntity();
        w1.setMsgTime(new Date());
        w1.setMsgType(WebSocketCode.INMONITORING_CAR_COUNT.getMsgType());
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name","keqi");
        map1.put("age", 23);
        w1.setMsgBody(map1);
        responseList.add(w1);

        return responseList;
    }


}
