
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
import com.withlee.dbm.domain.showapi.Iquest_content;
import com.withlee.dbm.persistence.mapper.showapi.Paper;
import com.withlee.dbm.persistence.mapper.showapi.Quest_content;
import com.withlee.dbm.service.showapi.PaperService;
import com.withlee.dbm.service.showapi.Quest_contentService;
import com.withlee.dbm.util.json.JSONUtils;
import com.withlee.dbm.util.response.CommonResponse;


@RestController
@RequestMapping("/quest_content")
public class Quest_contentController {

	private static Logger logger = LoggerFactory.getLogger(Quest_contentController.class);

	@Autowired
	private Quest_contentService quest_contentservice;

	
	
	/**
	 * 根据数据字典查询题目
	 */
	@RequestMapping(value = "/list/{questType}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getPaper(@PathVariable String questType) throws Exception {
		String address="http://route.showapi.com/119-42";
		try {			
			String vsyear=questType;
			
			List<Iquest_content> list=this.quest_contentservice.getquest_content(questType);	
			if(list ==null || list.size()<1){
				String date=questType;
				//String res=ShowApiComm.callShowApi(address).addTextPara("date",date).post();
				String res="";
				List<Quest_content> listdata=getListFJsonStr(res);
				for(int i=0;i<listdata.size();i++){
					Quest_content quest_content=listdata.get(i);
					Iquest_content iquest_content=new Iquest_content();
				
					quest_contentservice.addquest_content(iquest_content);
				}	
				return new CommonResponse(res);	
			}else{
				return new CommonResponse(list);
			}
			
		} catch (Exception e) {
			logger.error("[getquest_content] - fail to getquest_content " + e.getMessage());
			return new CommonResponse("查询[试卷题目]异常");
		}

	}
	
	public List<Quest_content> getListFJsonStr(String res){
		
		ShowReturnBean showReturnBean=JSONUtils.toBean(res, ShowReturnBean.class);	
		Map<String,String> showapi_res_body=showReturnBean.getShowapi_res_body();	
		Object s= showapi_res_body.get("list");	     
		List<Quest_content> list = JSON.parseArray(s.toString(),Quest_content.class);  
		return list;
	}

}
