package com.keqi.grid.sys.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Data
public class AccountVO {

    private Long id;

    private String account;

    private String nickName;

    private String phone;

    private Integer gender;

    private LocalDate birthday;

    private String email;

    private String note;

    private String password;

    private String salt;

    private String fileName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer deleted;

}