package com.keqi.apihu.core.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.keqi.apihu.core.common.LoginUserBO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类
 */
public class JWTUtil {

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
	 * @param accessToken accessToken
	 * @return r
	 */
	public static LoginUserBO generateToken(String accessToken) {
		Claims body = null;
		try {
			body = Jwts.parser().setSigningKey(secret)
					.parseClaimsJws(accessToken)
					.getBody();
		} catch (Exception e) {
			// 秘钥被篡改/过期等等时，解析就会抛出异常
			return null;
		}
		// 换成LoginUserBo对象
		return BeanUtil.mapToBean(body, LoginUserBO.class, true);
	}
}
