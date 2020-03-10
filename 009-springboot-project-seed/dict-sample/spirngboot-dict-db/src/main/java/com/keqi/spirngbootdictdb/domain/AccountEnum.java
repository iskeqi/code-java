package com.keqi.spirngbootdictdb.domain;

import com.keqi.spirngbootdictdb.common.BaseEntity;
import com.keqi.spirngbootdictdb.enums.ActiveFlagEnum;
import com.keqi.spirngbootdictdb.enums.UserTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class AccountEnum extends BaseEntity {

    private String account;

    private String password;

    private String accountName;

    private UserTypeEnum userType;

    private ActiveFlagEnum activeFlag;

}