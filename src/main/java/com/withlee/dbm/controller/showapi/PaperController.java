
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

import com.withlee.dbm.persistence.mapper.showapi.Paper;

import com.withlee.dbm.service.showapi.PaperService;

import com.withlee.dbm.util.json.JSONUtils;
import com.withlee.dbm.util.response.CommonResponse;


@RestController
@RequestMapping("/paper")
public class PaperController {

	private static Logger logger = LoggerFactory.getLogger(PaperController.class);

	@Autowired
	private PaperService paperservice;

	
	
	/**
	 * 根据试卷类型查询试卷列表
	 */
	@RequestMapping(value = "/list/{paperType}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getPaper(@PathVariable String paperType) throws Exception {
		String address="http://route.showapi.com/119-42";
		try {			
			String vsyear=paperType;
			
			List<IPaper> list=this.paperservice.getIPaper(paperType);	
			if(list ==null || list.size()<1){
				String date=paperType;
				String res="";
				//String res=ShowApiComm.callShowApi(address).addTextPara("date",date).post();
				List<Paper> listdata=getListFJsonStr(res);
				for(int i=0;i<listdata.size();i++){
					Paper paper=listdata.get(i);
					IPaper ipaper=new IPaper();
				
					paperservice.addIPaper(ipaper);
				}	
				return new CommonResponse(res);	
			}else{
				return new CommonResponse(list);
			}
			
		} catch (Exception e) {
			logger.error("[getPaper] - fail to getPaper " + e.getMessage());
			return new CommonResponse("查询[试卷列表]异常");
		}

	}
	
	public List<Paper> getListFJsonStr(String res){
		
		ShowReturnBean showReturnBean=JSONUtils.toBean(res, ShowReturnBean.class);	
		Map<String,String> showapi_res_body=showReturnBean.getShowapi_res_body();	
		Object s= showapi_res_body.get("list");	     
		List<Paper> list = JSON.parseArray(s.toString(),Paper.class);  
		return list;
	}

}
