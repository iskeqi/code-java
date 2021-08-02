package com.keqi.forestgetui.forest.getui.domain.dto;

import lombok.Data;

@Data
public class PushListCidDto {

    private TaskId $taskid;

    @Data
    public static class TaskId {
        private String $cid;
    }
}
