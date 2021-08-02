package com.keqi.forestgetui.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keqi.forestgetui.forest.getui.GeTuiUtil;
import com.keqi.forestgetui.forest.getui.domain.param.PushSingleParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/test1")
    public boolean test1() throws JsonProcessingException {
        String cid = "230752ee62294ecb6983d80af131bcbf";

        ObjectMapper objectMapper = new ObjectMapper();
        PushSingleParam param = new PushSingleParam();
        String s = objectMapper.writeValueAsString(param);

        return GeTuiUtil.pushSingle(cid, s, null);
    }

    @GetMapping("/test2")
    public boolean test2() throws JsonProcessingException {
        String cid = "230752ee62294ecb6983d80af131bcbf";

        ObjectMapper objectMapper = new ObjectMapper();
        PushSingleParam param = new PushSingleParam();
        String s = objectMapper.writeValueAsString(param);

        return GeTuiUtil.pushList(new String[]{cid}, s, null, null);
    }
}
