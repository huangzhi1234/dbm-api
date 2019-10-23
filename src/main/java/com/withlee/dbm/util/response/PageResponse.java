package com.withlee.dbm.util.response;

public class PageResponse {

	private int page;

	private int limit;

	private Object responseList;

	private int totalPage;

	// 成功返回
	public PageResponse(Object responseList) {
		super();
		this.responseList = responseList;
	}

	public Object getResponseList() {
		return responseList;
	}

	public void setResponseList(Object responseList) {
		this.responseList = responseList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
