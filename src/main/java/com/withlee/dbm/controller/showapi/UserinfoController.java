
package com.withlee.dbm.controller.showapi;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import com.withlee.dbm.controller.common.showapi.ShowReturnBean;
import com.withlee.dbm.domain.showapi.IPaper;
import com.withlee.dbm.domain.showapi.IUserinfo;
import com.withlee.dbm.persistence.mapper.showapi.Paper;
import com.withlee.dbm.persistence.mapper.showapi.Userinfo;
import com.withlee.dbm.service.showapi.PaperService;
import com.withlee.dbm.service.showapi.UserinfoService;
import com.withlee.dbm.util.json.JSONUtils;
import com.withlee.dbm.util.response.CommonResponse;


@RestController
@RequestMapping("/userinfo")
public class UserinfoController {

	private static Logger logger = LoggerFactory.getLogger(UserinfoController.class);

	@Autowired
	private UserinfoService userinfoService;

	
	
	/**
	 * 
	 */
	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getPaper(@PathVariable String username,@PathVariable String password) throws Exception {
		String address="http://route.showapi.com/119-42";
		try {			
			
			List<IUserinfo> list=this.userinfoService.getLogin(username, password);
			if(list ==null || list.size()<1){
				String date=username+password;
				String res="";
				//String res=ShowApiComm.callShowApi(address).addTextPara("date",date).post();
				List<Userinfo> listdata=getListFJsonStr(res);
				for(int i=0;i<listdata.size();i++){
				}	
				return new CommonResponse(res);	
			}else{
				return new CommonResponse(list);
			}
			
		} catch (Exception e) {
			logger.error("[getUserinfo] - fail to getUserinfo " + e.getMessage());
			return new CommonResponse("用户名密码错误！");
		}

	}
	
	public List<Userinfo> getListFJsonStr(String res){
		
		ShowReturnBean showReturnBean=JSONUtils.toBean(res, ShowReturnBean.class);	
		Map<String,String> showapi_res_body=showReturnBean.getShowapi_res_body();	
		Object s= showapi_res_body.get("list");	     
		List<Userinfo> list = JSON.parseArray(s.toString(),Userinfo.class);  
		return list;
	}

}
