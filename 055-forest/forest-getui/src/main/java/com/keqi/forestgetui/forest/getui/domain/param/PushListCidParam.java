package com.keqi.forestgetui.forest.getui.domain.param;

import lombok.Data;

@Data
public class PushListCidParam {

    private Audience audience;

    private String taskid;

    private Boolean is_async;

    @Data
    public static class Audience {
        private String[] cid;
    }
}
