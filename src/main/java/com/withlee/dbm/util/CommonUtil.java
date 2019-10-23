package com.withlee.dbm.util;

/**
 * @desc 普通工具类
 * @author linjiazhi
 * @since 2015年8月27日
 */
public class CommonUtil {

	/**
	 * @desc 字符串每个元素后面加"|",用于mysql正则.
	 * @demo "我想去跑步" =>"我|想|去|跑|步"
	 * @author linjiazhi
	 * @since 2015-8-27
	 */
	public static String addElement(String s) {

		StringBuffer s1 = new StringBuffer(s);

		StringBuffer s2 = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			s2.append(s1.substring(i, i + 1) + ("|"));
		}
		return s2.substring(0, s2.length() - 1).toString();
	}

}
