package com.asher.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class MyStringUtils {
	/**
	 * MD5加密
	 * @param value 明文
	 * @return 密文
	 */
	public static String getMD5Value(String value){
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
			BigInteger bigInteger = new BigInteger(1,md5ValueByteArray);
			
			return bigInteger.toString(16);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获得一个32长度的UUID值
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
