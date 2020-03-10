package com.keqi.spirngbootdictdb.domain;

import lombok.Data;

@Data
public class AccountVO {

    private Long id;

    private String account;

    private String accountName;

    private String userType;

    private String userTypeName;

    private String activeFlag;

    private String activeFlagName;

}