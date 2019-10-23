package com.withlee.dbm.util.callhttp;

import org.springframework.beans.BeansException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.ning.http.client.AsyncHttpClient;

@Component
public class AsyncHttpClientHelper implements ApplicationContextAware {
	
	private static AsyncHttpClient asyncHttpClient;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		asyncHttpClient = applicationContext.getBean("asyncHttpClient", AsyncHttpClient.class);
	}
	
	public static AsyncHttpClient getHttpClient(){
		return asyncHttpClient;
	}
}
