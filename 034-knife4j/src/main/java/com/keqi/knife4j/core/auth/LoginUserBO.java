package com.keqi.knife4j.core.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录用户信息实体类
 *
 * @author keqi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserBO {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 登录用户账号名
     */
    private String account;

    /**
     * 登录用户姓名
     */
    private String nickName;
}
