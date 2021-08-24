package com.keqi.nettyserverhaier;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.concurrent.CountDownLatch;

/**
 * 请求上位机控制 plc 响应实体类（上位机 -> 中控）
 *
 * @author keqi
 */
public class CommandProducerResp {

    /**
     * Request id (Simple UUID)
     */
    @JSONField(name = "Id")
    private String Id;

    @JSONField(name = "Result")
    private String Result;

    private transient CountDownLatch countDownLatch;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
}
