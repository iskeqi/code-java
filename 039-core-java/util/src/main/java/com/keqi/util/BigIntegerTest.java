package com.keqi.util;

import java.math.BigInteger;

/**
 * @author keqi
 */
public class BigIntegerTest {
	
	public static void main(String[] args) {
		//Long a = 18446744073709551615L;
		BigInteger a = new BigInteger("18446744073709551615");
		BigInteger divide = a.divide(BigInteger.valueOf(10000L));
		BigInteger divide1 = divide.divide(BigInteger.valueOf(3600)).divide(BigInteger.valueOf(24));
		System.out.println(divide1.divide(BigInteger.valueOf(365)));
	}
}
