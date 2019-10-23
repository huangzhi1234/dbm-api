package com.withlee.dbm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Settings {

	@Value("${http.client.request_time_out}")
	public int httpClientRequestTimeOut;
	@Value("${http.client.max_conn_per_host}")
	public int httpClientMaxConnPerHost;
	@Value("${http.client.max_conn_total}")
	public int httpClientMaxConnTotal;

	/* 分享 */
	@Value("http://xxx.xxx.xxx")
	public String DOWNLOAD_SHARE_URL;
	@Value("content")
	public String DOWNLOAD_CONTENT;
	@Value("http://img05.tooopen.com/images/20150202/sy_80219211654.jpg")
	public String COVER_URL;
	@Value("5")
	public int INVITATION_SIZE;// 邀请人邀请客户可以添加积分的次数

	@Value("http://localhost:8080/")
	public String ADMIN_API;

	@Value("http://cdn.camiul.com/")
	public String CAMIUL_URL;
}
