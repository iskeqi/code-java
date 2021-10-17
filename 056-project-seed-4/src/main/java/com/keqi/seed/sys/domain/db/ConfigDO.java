package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName(value = "sys_config")
public class ConfigDO {

    /**
     * 配置项key
     */
    @TableField(value = "config_key")
    private String configKey;

    /**
     * 配置项value
     */
    @TableField(value = "config_value")
    private String configValue;

    /**
     * 配置项描述信息
     */
    @TableField(value = "note")
    private String note;
}
