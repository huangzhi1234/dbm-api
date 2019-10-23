
package com.withlee.dbm.controller.user;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.withlee.dbm.domain.user.AccountBinding;
import com.withlee.dbm.domain.user.UserAccount;
import com.withlee.dbm.redis.RedisService;
import com.withlee.dbm.service.user.UserService;
import com.withlee.dbm.util.Sign;
import com.withlee.dbm.util.authenticate.TokenUtils;
import com.withlee.dbm.util.constant.PlatformConstant;
import com.withlee.dbm.util.response.CommonResponse;

/**
 * @desc 用户模块Controller
 * @author linjiazhi
 * @since 2015年7月11日
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@Autowired
	private RedisService redisService;

	/**
	 * 第三方平台账号绑定接口:注册
	 */
	@RequestMapping(value = "/binding", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public CommonResponse accountBingding(@RequestBody AccountBinding accountBinding) throws Exception {

		String token = TokenUtils.createAccessToken();

		// 1.查绑定表,通过openid判断账号是否被绑定
		AccountBinding bindingResult = service.getBingding(accountBinding.getOpenId());
		try {
			if (StringUtils.isEmpty(accountBinding.getBindingType())) {
				logger.error("绑定类型为空");
				return new CommonResponse("绑定类型为空");
			}

			// 2.如果openid不为空表示用户存在,返回user信息+token
			if (bindingResult != null) {
				UserAccount userAccount = service.getUserInfo(bindingResult.getUserId());
				userAccount.setAccessToken(token);
				// 设置token有效期为一个月,正式联调再放开Redis
				redisService.set(PlatformConstant.USER_ACCESS_TOKEN_PREFIX + token, userAccount.getUserId().toString(),
						PlatformConstant.TOKEN_INDATE_ONE_MONTH);
				return new CommonResponse(userAccount);
			} else {// 这是openid找不到记录的情况,表示绑定注册,往2张表插记录.先往UserAccount插,再插AccountBinding.

				// 账号密码由后台生成,生成规则:bind_bindtype_timestamp
				String timestrap = Sign.create_timestamp();
				String accountAndpwd = "bind_" + accountBinding.getBindingType() + "_" + timestrap;
				accountBinding.setAccount(accountAndpwd);
				accountBinding.setUserPassword(TokenUtils.toMd5(accountAndpwd));

				// username = nickname
				if (StringUtils.isEmpty(accountBinding.getNickName())) {
					accountBinding.setNickName("weixin" + timestrap);
				}
				accountBinding.setUserName(accountBinding.getNickName());
				accountBinding.setRegisterTime(new Date());
				accountBinding.setLastLoginTime(new Date());

				UserAccount userAccount = service.addUserAndBingDing(accountBinding);
				userAccount.setAccessToken(token);
				redisService.set(PlatformConstant.USER_ACCESS_TOKEN_PREFIX + token, userAccount.getUserId().toString(),
						PlatformConstant.TOKEN_INDATE_ONE_MONTH);
				return new CommonResponse(userAccount);
			}
		} catch (Exception e) {
			logger.error("[accountBingding] - fail to accountBingding " + e.getMessage());
			return new CommonResponse("绑定异常");
		}
	}

	/**
	 * 登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public CommonResponse getUser(@RequestBody JSONObject json) throws IOException {

		try {
			UserAccount user = this.service.getUser(json.getString("account"), json.getString("userPassword"));

			if (user == null) {
				return new CommonResponse("账号或密码错误");
			}

			String token = TokenUtils.createAccessToken();
			user.setAccessToken(token);
			redisService.set(PlatformConstant.USER_ACCESS_TOKEN_PREFIX + token, user.getUserId().toString(),
					PlatformConstant.TOKEN_INDATE_ONE_MONTH);
			return new CommonResponse(user);
		} catch (Exception e) {
			logger.error("[getUser] - fail to getUser " + e.getMessage());
			return new CommonResponse("登录异常");
		}

	}

}
