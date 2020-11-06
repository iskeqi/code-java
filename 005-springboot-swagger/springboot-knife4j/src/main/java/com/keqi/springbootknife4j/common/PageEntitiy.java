package com.keqi.springbootknife4j.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageEntitiy<T> {

    @ApiModelProperty(value = "总记录数", required = true, example = "200")
    private Long total;

    @ApiModelProperty(value = "记录列表", required = true)
    private List<T> records;

}
