package com.keqi.spirngbootdictdb.domain;

import com.keqi.spirngbootdictdb.common.BaseEntity;
import lombok.Data;

@Data
public class Account extends BaseEntity {

    private String account;

    private String password;

    private String accountName;

    private String userType;

    private String activeFlag;

}