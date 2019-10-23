package com.withlee.dbm.enums;

public enum SignEnum {

	client_android("1", "WDCE4G1FH3IIQPJ3O33ZI5CX0308VDC98BZH8OE4VEVN2K6KRDERIEEX3WZF096A"),

	client_ios("2", "IJ0L4G1FH3IIQPJAO33ZI5CX0308VDC98BZH8OE4VEYN2K6KRDERIEEX3WZF096A"),

	client_webapp("3", "GSWS4G1FH3IIQPJ4O33ZI5CX0308VDC98BZH8OE4VEVN2K6KRDERIEEX3WZF096A"),

	;

	/**
	 * 构造方法。
	 */
	private String key;
	private String code;

	private SignEnum(String code, String key) {
		this.key = key;
		this.code = code;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
