package com.keqi.getui.transmission;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<String> cids = new ArrayList<>();
        cids.add("2930119df12a5c611aa76455d1e91580");

        String message = "{\"user\":\"用户ID\",\"action\":\"task或者event或者warning\",\"data\":{\"id\":\"任务ID或者事件ID或者报警ID\"}}";

        Map<String, Object> stringObjectMap = PushListUtil.pushTransmissionMessageToList(cids, message);

        System.out.println(stringObjectMap);
    }
}
