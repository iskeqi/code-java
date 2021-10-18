package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.seed.core.pojo.BaseDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户表
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_account")
public class AccountDO extends BaseDO {

    @ApiModelProperty("用户名")
    private String account;

    @ApiModelProperty("姓名")
    private String nickName;

    @ApiModelProperty("岗位")
    private String post;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("盐")
    private String salt;
}