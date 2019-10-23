package com.withlee.dbm.controller.common.showapi;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.show.api.ShowApiRequest;
import com.withlee.dbm.persistence.mapper.showapi.HistoryToday;
import com.withlee.dbm.util.json.JSONUtils;

public class TestApi {
	
	/*
	public static void main(String[] args) {
		String res=new ShowApiRequest
				(Constants.history_taday_address,
						Constants.appid,
						Constants.appkey)
		.addTextPara("date","0611")
	  .post();
	
	ShowReturnBean showReturnBean=JSONUtils.toBean(res, ShowReturnBean.class);
	//System.out.println("showapi_res_code="+showReturnBean.showapi_res_code);
	//System.out.println("showapi_res_error="+showReturnBean.showapi_res_error);
	
	Map<String,String> showapi_res_body=showReturnBean.getShowapi_res_body();
	
	Object s1= showapi_res_body.get("ret_code");
	Object s2= showapi_res_body.get("list");
	System.out.println("s1="+s1.toString());
	System.out.println("s2="+s2.toString());
	
     
	List<HistoryToday> list = JSON.parseArray(s2.toString(), HistoryToday.class);  
	
	//List<HistoryToday> list=(List<HistoryToday>) s2;
	System.out.println("list="+list);
	System.out.println("size="+list.size());
	for(int i=0;i<list.size();i++){
		HistoryToday HistoryToday=list.get(i);
		System.out.println(HistoryToday.getTitle());
	}
	}
	*/
}
