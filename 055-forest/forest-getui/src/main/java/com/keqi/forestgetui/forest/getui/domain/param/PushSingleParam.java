package com.keqi.forestgetui.forest.getui.domain.param;

import lombok.Data;

import java.util.UUID;

@Data
public class PushSingleParam {

    private String request_id = UUID.randomUUID().toString().replaceAll("-", "");

    private Settings settings;

    private Audience audience;

    private PushMessage push_message;

    @Data
    public static class Settings {
        private Long ttl;
    }

    @Data
    public static class Audience {
        private String[] cid;
    }

    @Data
    public static class PushMessage {
        private String transmission;
    }
}
