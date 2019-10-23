package com.withlee.dbm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:DateTime
 */
public class DateTime {
	public static final String TIMEFORMAT = "yyyyMMddHHmmss";
	public static final String YYYYMMDD = "yyyy-MM-dd";

	/**
	 * 
	 * convertDateStringToLong: 将前台传入的时间字符串转为Long类型
	 * 
	 * @param @param
	 *            date @param @return 设定文件 @return Long DOM对象 @throws
	 */
	public static Long convertDateStringToLong(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date newDate = null;
		try {
			newDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate.getTime();
	}

	/**
	 * 
	 * @desc convertDateLongToString:将数据库中的Long时间转为String类型
	 * @desc 同步锁,避免重复 add by lin 2015.9.16
	 * 
	 * @param @param
	 *            date @param @return 设定文件 @return String DOM对象 @throws
	 */
	public static synchronized String convertDateLongToString(Long date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date newDate = new Date(date);
		return sdf.format(newDate);
	}

	public static String convertLongStrToString(String longDate, String format) {
		try {
			long date = Long.parseLong(longDate);
			return convertDateLongToString(date, format);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	public static String getCurrentTime() {
		return convertDateLongToString(System.currentTimeMillis(), TIMEFORMAT);
	}

	/*
	 public static void main(String[] args) {
	 System.out.println(convertDateStringToLong("2011-05-04 15:37:56", "yyyy-MM-dd HH:mm:ss"));
	 System.out.println(convertDateLongToString(System.currentTimeMillis(), "yyyyMMdd"));
	 System.out.println(System.currentTimeMillis());
	 }
	*/ 

}
