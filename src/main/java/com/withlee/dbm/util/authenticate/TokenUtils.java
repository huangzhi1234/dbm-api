package com.withlee.dbm.util.authenticate;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @desc
 * @author linjiazhi
 * @since 2015年7月11日
 */
public class TokenUtils {

	/**
	 * 生成token
	 */
	public static String createAccessToken() {
		// String token = UUID.randomUUID().toString();
		return UUID.randomUUID().toString();
	}

	/**
	 * MD5加密算法
	 * 
	 * @param inputValue
	 *            要加密的字符
	 * @return MD5串
	 */
	public static String toMd5(String inputValue) {
		if (inputValue == null)
			return "";

		try {
			MessageDigest m = MessageDigest.getInstance("MD5");

			m.update(inputValue.getBytes("UTF8"));
			byte s[] = m.digest();

			String result = "";
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
			}

			return result.toUpperCase();// MD5加密统一用转大写
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}

}
