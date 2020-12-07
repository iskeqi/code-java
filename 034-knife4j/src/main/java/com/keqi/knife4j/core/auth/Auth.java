package com.keqi.knife4j.core.auth;

import com.keqi.knife4j.core.pojo.CommonConstant;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 登录用户信息工具类（通过 ThreadLocal 存储用户信息）
 *
 * @author keqi
 */
@Component
public class Auth {

    private static final ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    /**
     * 获取当前线程操作用户登录名
     * <bind name="loginAccount" value="@com.keqi.knife4j.core.auth.Auth@getLoginAccount()"/>
     *
     * @return r
     */
    public static String getLoginAccount() {
        return getLoginUserBO() == null ? null : getLoginUserBO().getAccount();
    }


    public static String getLoginAccountName() {
        return getLoginUserBO() == null ? null : getLoginUserBO().getNickName();
    }

    public static Long getLoginAccountId() {
        return getLoginUserBO() == null ? null : getLoginUserBO().getId();
    }

    /**
     * 获取当前登录用户登录信息
     *
     * @return r
     */
    public static LoginUserBO getLoginUserBO() {
        Map<String, Object> stringObjectMap = threadLocal.get();
        if (Objects.isNull(stringObjectMap)) {
            return null;
        }
        return (LoginUserBO) stringObjectMap.get(CommonConstant.LOGIN_USER);
    }


    /**
     * 设置当前登录用户信息
     *
     * @param loginUserBO loginUserBO
     */
    public static void setLoginUserBO(LoginUserBO loginUserBO) {
        Map<String, Object> stringObjectMap = threadLocal.get();
        if (Objects.isNull(stringObjectMap)) {
            stringObjectMap = new HashMap<>();
            threadLocal.set(stringObjectMap);
        }
        stringObjectMap.put(CommonConstant.LOGIN_USER, loginUserBO);
    }


}
