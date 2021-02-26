package com.keqi.springsecurityjwt.core.util;

import cn.hutool.core.bean.BeanUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类
 *
 * @author keqi
 */
public class JwtUtil {

    private static final String secret = "1O!dZ@%YXsvOaKHC";

    /**
     * 生成token
     *
     * @param claims         claims
     * @param expirationDate expirationDate
     * @return r
     */
    public static String generateToken(Map<String, Object> claims, Date expirationDate) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 解析token
     *
     * @param token token
     * @return r
     */
    public static <T> T resolveToken(String token, Class<T> clazz) {
        Claims body;
        try {
            body = Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            // 秘钥被篡改/过期等等时，解析就会抛出异常
            return null;
        }
        return BeanUtil.toBean(body, clazz);
    }
}
