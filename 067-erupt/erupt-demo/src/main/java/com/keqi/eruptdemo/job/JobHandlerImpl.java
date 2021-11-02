package com.keqi.eruptdemo.job;

import org.springframework.stereotype.Service;
import xyz.erupt.core.annotation.EruptHandlerNaming;
import xyz.erupt.job.handler.EruptJobHandler;

@Service
@EruptHandlerNaming("自定义任务")  // 如果不添加此配置，类名会作为前端展示依据
public class JobHandlerImpl implements EruptJobHandler {

    /**
     * @param code  任务编码
     * @param param 任务参数
     */
    @Override
    public String exec(String code, String param) {
        // TODO
        return null;
    }

}

