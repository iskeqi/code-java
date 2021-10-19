package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@TableName(value = "sys_config")
public class ConfigDO {

    @NotBlank
    @ApiModelProperty("配置项key")
    private String configKey;

    @NotBlank
    @ApiModelProperty("配置项value")
    private String configValue;

    @ApiModelProperty("配置项描述信息")
    private String note;
}
