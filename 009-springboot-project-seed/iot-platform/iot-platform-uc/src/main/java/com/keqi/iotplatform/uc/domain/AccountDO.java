package com.keqi.iotplatform.uc.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.iotplatform.core.common.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "t_uc_account")
public class AccountDO extends BaseDO {

	private String account;

	private String password;

	private String accountName;

	private Integer userType;

	private String phone;

	private String email;

	private String photoUrl;

	private String uiTheme;

	private Long orgId;

	private Long tenantId;

	private Integer activeFlag;

	private Integer updatePasswordFlag;

}
