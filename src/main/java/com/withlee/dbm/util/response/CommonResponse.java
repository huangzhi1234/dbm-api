package com.withlee.dbm.util.response;

public class CommonResponse {

	private String message;

	private Object responseContent;

	private int status;

	// 执行查询成功返回
	public CommonResponse(Object responseContent) {
		super();
		this.message = "success";
		this.responseContent = responseContent;
		this.status = 0;
	}

	// 执行增删改操作成功返回
	public CommonResponse() {
		super();
		this.message = "success";
		this.responseContent = null;
		this.status = 0;
	}

	// 业务逻辑层错误(通常用这种):统一返回message和状态码400
	public CommonResponse(String message) {
		super();
		this.message = message;
		this.responseContent = false;
		this.status = 400;
	}

	// 错误 :如token失效
	public CommonResponse(String message, int status) {
		super();
		this.message = message;
		this.responseContent = null;
		this.status = status;
	}

	// 公用返回
	public CommonResponse(String message, Object responseContent, int status) {
		super();
		this.message = message;
		this.responseContent = responseContent;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(Object responseContent) {
		this.responseContent = responseContent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
