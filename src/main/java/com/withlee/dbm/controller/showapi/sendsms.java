package com.withlee.dbm.controller.showapi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;





import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.withlee.dbm.domain.showapi.ITest3;
import com.withlee.dbm.util.json.JSONUtils;
import com.withlee.dbm.util.response.CommonResponse;


public class sendsms {
	
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	
	
	public void httpGet(){
		HttpClient client = new HttpClient(); 
		String url="http://localhost:8001/test3/list/3";
		GetMethod gm=new GetMethod(url);
		client.getParams().setContentCharset("GBK");
		gm.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
		//gm.setQueryString("1");
		try {
			client.executeMethod(gm);
			String res=gm.getResponseBodyAsString();
			System.out.println("res="+res);
			CommonResponse commonResponse=JSONUtils.toBean(res, CommonResponse.class);
			String a=commonResponse.getMessage();
			String json=commonResponse.getResponseContent().toString();
			
			List<ITest3> list=JSONUtils.jsonToList(json, ITest3.class);
			
			System.out.println("size:"+list.size());
			for(int i=0;i<list.size();i++){
				ITest3 iTest3=list.get(i);
				System.out.println("custname="+iTest3.getCustname());
				System.out.println("custnum="+iTest3.getCustnum());
				
			}
			
			
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void httpPost(){
		HttpClient client = new HttpClient(); 
		String uri="http://localhost:8001/test3/add";
		PostMethod method = new PostMethod(uri);
		client.getParams().setContentCharset("utf-8");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=utf-8");
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("custnum", "88");
		jsonParam.put("custname", "88");
		jsonParam.put("pname", "88");
		String transJson = jsonParam.toString();
        RequestEntity se;
		try {
			se = new StringRequestEntity(transJson, "application/json", "UTF-8");
			method.setRequestEntity(se);
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 3000);
            
            client.executeMethod(method);
            String SubmitResult =method.getResponseBodyAsString();
            
            System.out.println("SubmitResult :"+SubmitResult);
	         
            
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	
	}
	

	
}