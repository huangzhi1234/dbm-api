package com.withlee.dbm.util;

/**
 * 因为手机不能存储第一位为0的随机码,因此在随机码生成时，限制第一位不能为0
 *
 */
public class RandomCode {

	public static char[] generateCode16() {
		// 定义验证码的字符表
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		char[] rands = new char[16];

		// 生成随机数第一位不能为0
		int rand = (int) (Math.random() * 10);
		while (rand == 0)
			rand = (int) (Math.random() * 10);
		rands[0] = chars.charAt(rand);

		for (int i = 0; i < 16; i++) {
			rand = (int) (Math.random() * 36);
			rands[i] = chars.charAt(rand);
		}

		return rands;
	}

	public static char[] generateCode12() {
		// 定义验证码的字符表
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		char[] rands = new char[12];
		int rand;

		for (int i = 0; i < 12; i++) {
			rand = (int) (Math.random() * 36);
			rands[i] = chars.charAt(rand);
		}

		return rands;
	}

	public static char[] generateCode10() {
		// 定义验证码的字符表
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		char[] rands = new char[10];
		int rand;

		for (int i = 0; i < 10; i++) {
			rand = (int) (Math.random() * 36);
			rands[i] = chars.charAt(rand);
		}

		return rands;
	}

	public static char[] generateCode5() {
		// 定义验证码的字符表
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		char[] rands = new char[5];
		int rand;

		for (int i = 0; i < 5; i++) {
			rand = (int) (Math.random() * 36);
			rands[i] = chars.charAt(rand);
		}

		return rands;
	}

	/**
	 * 得到随机数字
	 * 
	 * @param num
	 *            得到几位的随机数字
	 * @return
	 */
	public static String generateNumCode(int num) {
		// 定义验证码的字符表
		String chars = "0123456789";

		char[] rands = new char[num];
		int rand;

		for (int i = 0; i < num; i++) {
			rand = (int) (Math.random() * 10);
			rands[i] = chars.charAt(rand);
		}
		return new String(rands);
	}

}
