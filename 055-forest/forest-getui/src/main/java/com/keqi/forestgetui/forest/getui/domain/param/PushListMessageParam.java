package com.keqi.forestgetui.forest.getui.domain.param;

import lombok.Data;

import java.util.UUID;

@Data
public class PushListMessageParam {

    private String request_id = UUID.randomUUID().toString().replaceAll("-", "");

    private String group_name;

    private Settings settings;

    private PushMessage push_message;

    @Data
    public static class Settings {
        private Long ttl;
    }

    @Data
    public static class PushMessage {
        private String transmission;
    }
}
