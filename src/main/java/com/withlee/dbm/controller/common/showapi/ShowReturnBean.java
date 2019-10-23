package com.withlee.dbm.controller.common.showapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowReturnBean<T> {
	public String showapi_res_error;
	public String showapi_res_code;
	public Map showapi_res_body=new HashMap<String, List<T>>(); 
	
	public ShowReturnBean() {
		super();
	}
	
	public ShowReturnBean(String showapi_res_error,String showapi_res_code
			,Map map){
		this.showapi_res_code=showapi_res_error;
		this.showapi_res_error=showapi_res_code;
		this.showapi_res_body=map;
	}

	public String getShowapi_res_error() {
		return showapi_res_error;
	}

	public void setShowapi_res_error(String showapi_res_error) {
		this.showapi_res_error = showapi_res_error;
	}

	public String getShowapi_res_code() {
		return showapi_res_code;
	}

	public void setShowapi_res_code(String showapi_res_code) {
		this.showapi_res_code = showapi_res_code;
	}

	public Map getShowapi_res_body() {
		return showapi_res_body;
	}

	public void setShowapi_res_body(Map showapi_res_body) {
		this.showapi_res_body = showapi_res_body;
	}
	
	

}
