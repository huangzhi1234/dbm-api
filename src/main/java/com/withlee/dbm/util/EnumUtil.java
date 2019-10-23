package com.withlee.dbm.util;

import com.withlee.dbm.enums.SignEnum;

public class EnumUtil {
	public static SignEnum getSignEnum(String code) {
		SignEnum sign = null;
		for (SignEnum bo : SignEnum.values()) {
			if (bo.getCode().equals(code)) {
				sign = bo;
				break;
			}
		}
		return sign;

	}
}
