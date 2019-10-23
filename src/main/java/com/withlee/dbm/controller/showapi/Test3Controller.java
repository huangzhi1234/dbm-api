
package com.withlee.dbm.controller.showapi;




import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.withlee.dbm.controller.common.showapi.ShowReturnBean;
import com.withlee.dbm.domain.showapi.ITest3;
import com.withlee.dbm.persistence.mapper.showapi.Answer_content;
import com.withlee.dbm.persistence.mapper.showapi.Test3;
import com.withlee.dbm.service.showapi.Test3Service;
import com.withlee.dbm.util.json.JSONUtils;
import com.withlee.dbm.util.response.CommonResponse;



@RestController
@RequestMapping("/test3")
public class Test3Controller {

	private static Logger logger = LoggerFactory.getLogger(Test3Controller.class);

	@Autowired
	private Test3Service test3Service;

	
	
	/**
	 * 
	 */
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getTest3(@PathVariable String id) throws Exception {
		try {			
			String vsyear=id;
			
			List<ITest3> list=this.test3Service.getTest3(id);	
			return new CommonResponse(list);
			
		} catch (Exception e) {
			logger.error("[getquest_content] - fail to getquest_content " + e.getMessage());
			return new CommonResponse("答案表暂无数据");
		}

	}
	
	public List<Answer_content> getListFJsonStr(String res){
		
		ShowReturnBean showReturnBean=JSONUtils.toBean(res, ShowReturnBean.class);	
		Map<String,String> showapi_res_body=showReturnBean.getShowapi_res_body();	
		Object s= showapi_res_body.get("list");	     
		List<Answer_content> list = JSON.parseArray(s.toString(),Answer_content.class);  
		return list;
	}
	
	/**
	 * 增加
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public CommonResponse addTest3(@RequestBody ITest3 test3) throws Exception {

		try {
			return new CommonResponse(this.test3Service.addTest3(test3));
		} catch (Exception e) {
			logger.error("[addAddress] - fail to addAddress " + e.getMessage());
			return new CommonResponse("新增信息失败");
		}
	}

}
