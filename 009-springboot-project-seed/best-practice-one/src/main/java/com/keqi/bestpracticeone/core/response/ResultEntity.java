package com.keqi.bestpracticeone.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应实体类
 *
 * @author keqi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity {

    private Integer status;

    private String msg;

    private Object body;
}
