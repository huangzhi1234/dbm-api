
package com.withlee.dbm.controller.showapi;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.withlee.dbm.domain.showapi.IRegister;


import com.withlee.dbm.service.showapi.RegisterService;
import com.withlee.dbm.util.response.CommonResponse;




@RestController
@RequestMapping("/register")
public class RegisterController  {

	private static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private RegisterService registerservice;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse register()throws Exception {
		//IcHistorytoday icHistorytoday=new IcHistorytoday();
		IRegister iregister=new IRegister();
		

	
		iregister.setUsername("注册测试");
		iregister.setPhone("13129999999");
		iregister.setPassword("123456");
		iregister.setProfessional("注册测试");
		iregister.setSchool("注册测试");
		iregister.setLevel("普通用户");
		registerservice.addRegister(iregister);
		return new CommonResponse("用户注册成功！");
		

	}


}
