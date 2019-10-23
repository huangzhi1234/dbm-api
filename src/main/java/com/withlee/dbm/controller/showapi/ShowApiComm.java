package com.withlee.dbm.controller.showapi;

import com.show.api.ShowApiRequest;
import com.withlee.dbm.controller.common.showapi.Constants;

public class ShowApiComm {
	public static ShowApiRequest showApiRequest=null;
	public static ShowApiRequest callShowApi(String address){
		showApiRequest=new ShowApiRequest
	       (address,
			Constants.appid,
			Constants.appkey);
		return showApiRequest;
	}

}
