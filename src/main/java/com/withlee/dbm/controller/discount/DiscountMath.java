package com.withlee.dbm.controller.discount;

import java.text.DecimalFormat;

/**
 * 
 * @desc 优惠码算法
 * @author linjiazhi
 * @since 2015年8月18日
 *
 */
public class DiscountMath {

	/**
	 * @desc 商品价格折扣算法
	 * @mark 业务员添加红包选折扣优惠,则使用如下方法.比如打8.8折扣,输入8.8即可,7折就输入7即可.
	 */
	public double disCount(double amount, double disValue) {
		// 取小数点后两位
		if (disValue > 10) {
			disValue = 10;
		}
		DecimalFormat df = new DecimalFormat("#.##");
		double d = Double.parseDouble(df.format(amount * disValue * 0.1));
		// System.out.println(d);
		return d;
	}

	// 冲抵现金算法
	public double subAmount(double amount, double disValue) {
		double result = amount - disValue;

		if (result <= 0) {
			result = 0;
		}
		// System.out.println(result);
		return result;
	}

	// public static void main(String[] args) {
	//
	// DiscountMath discountMath=new DiscountMath();
	// discountMath.disCount(100.10, 8);
	// discountMath.subAmount(100, 38);
	// }

}
