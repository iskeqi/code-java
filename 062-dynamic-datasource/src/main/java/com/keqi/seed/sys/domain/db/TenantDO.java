package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.seed.core.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 租户信息表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_tenant")
public class TenantDO extends BaseDO {

    /**
     * 租户名称
     */
    @TableField(value = "`tenant_name`")
    private String tenantName;

    /**
     * 租户唯一标识符
     */
    @TableField(value = "tenant_identifier")
    private String tenantIdentifier;
}
