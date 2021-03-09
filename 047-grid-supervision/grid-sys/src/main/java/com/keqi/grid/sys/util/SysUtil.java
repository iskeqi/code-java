package com.keqi.grid.sys.util;

import cn.hutool.core.util.HexUtil;
import com.keqi.grid.core.exception.BusinessException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 系统管理模块工具类
 */
public class SysUtil {

    /**
     * 加密密码(登录时，也需要使用用此逻辑)
     *
     * @return r
     */
    public static String encryptedPassword(String password, String salt) {
        String result;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest((password + salt + password).getBytes());
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            result = HexUtil.encodeHexStr(sha256.digest(bytes));
        } catch (NoSuchAlgorithmException e) {
            throw new BusinessException("无此加密算法");
        }
        return result;
    }

}
