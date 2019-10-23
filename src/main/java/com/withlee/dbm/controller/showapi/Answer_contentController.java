
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

import com.withlee.dbm.domain.showapi.Ianswer_content;

import com.withlee.dbm.persistence.mapper.showapi.Answer_content;

import com.withlee.dbm.service.showapi.Answer_contentService;

import com.withlee.dbm.util.json.JSONUtils;
import com.withlee.dbm.util.response.CommonResponse;


@RestController
@RequestMapping("/answer_content")
public class Answer_contentController {

	private static Logger logger = LoggerFactory.getLogger(Answer_contentController.class);

	@Autowired
	private Answer_contentService answer_contentservice;

	
	
	/**
	 * 根据题目查询答案
	 */
	@RequestMapping(value = "/list/{questId}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getPaper(@PathVariable String questId) throws Exception {
		String address="http://route.showapi.com/119-42";
		try {			
			String vsyear=questId;
			
			List<Ianswer_content> list=this.answer_contentservice.getanswer_content(questId);	
			if(list ==null || list.size()<1){
				String date=questId;
				String res=ShowApiComm.callShowApi(address).addTextPara("date",date).post();	
				List<Answer_content> listdata=getListFJsonStr(res);
				for(int i=0;i<listdata.size();i++){
					Answer_content answer_content=listdata.get(i);
					Ianswer_content ianswer_content=new Ianswer_content();
				
					answer_contentservice.addanswer_content(ianswer_content);
				}	
				return new CommonResponse(res);	
			}else{
				return new CommonResponse(list);
			}
			
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

}
