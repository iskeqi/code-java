package com.keqi.apihu.core.util;

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
	 * @param claims claims
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
}
