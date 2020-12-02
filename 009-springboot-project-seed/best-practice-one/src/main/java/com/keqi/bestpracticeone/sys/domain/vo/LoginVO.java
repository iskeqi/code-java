package com.keqi.bestpracticeone.sys.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    /**
     * 登录返回token
     */
    private String accessToken;
}
