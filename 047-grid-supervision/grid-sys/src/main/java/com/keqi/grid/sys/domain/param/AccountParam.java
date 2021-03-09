package com.keqi.grid.sys.domain.param;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class AccountParam {

    private Long id;

    @NotNull
    private String nickName;

    @NotNull
    private String phone;

    private Integer gender;

    private LocalDate birthday;

    private String email;

    private String note;

    private String fileName;

    private List<Long> gridIds;

    @NotNull
    private Long roleId;
}