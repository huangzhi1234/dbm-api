package com.withlee.dbm.util;

public class MsgEntity {
	private String code;//短信提交返回状态码
	private String msg;
	private String smsid;
	private String valCode;//验证码
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSmsid() {
		return smsid;
	}
	public void setSmsid(String smsid) {
		this.smsid = smsid;
	}
	
	public String getValCode() {
		return valCode;
	}
	public void setValCode(String valCode) {
		this.valCode = valCode;
	}
	public MsgEntity(String code, String msg, String smsid,String valCode) {
		super();
		this.code = code;
		this.msg = msg;
		this.smsid = smsid;
		this.valCode = valCode;
	}
	public MsgEntity() {
	}
	
}
