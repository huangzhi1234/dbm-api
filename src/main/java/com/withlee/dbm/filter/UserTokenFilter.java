package com.withlee.dbm.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;
import com.withlee.dbm.enums.SignEnum;
import com.withlee.dbm.redis.RedisService;
import com.withlee.dbm.util.EnumUtil;
import com.withlee.dbm.util.authenticate.ErrorObject;
import com.withlee.dbm.util.authenticate.TokenUtils;
import com.withlee.dbm.util.authenticate.UrlChecker;
import com.withlee.dbm.util.constant.PlatformConstant;

/**
 * @desc Token认证
 * @author linjiazhi
 * @since 2015年7月11日
 */
@Component
public class UserTokenFilter extends OncePerRequestFilter {

	private static final Logger _logger = LoggerFactory.getLogger(UserTokenFilter.class);

	@Autowired
	private RedisService redisService;

	@Autowired
	private UrlChecker whitelistUrlChecker;

	@Value("${sign.ios}")
	String iosKey;

	@Value("${sign.android}")
	String androidKey;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		/********************** 签名逻辑开始 **********************/
		String client_os = request.getHeader("CLIENT_OS");// 客户端操作系统：如Android、IOS等
		String request_time = request.getHeader("REQUEST_TIME");// 请求时间戳
		String request_id = request.getHeader("REQUEST_ID");
		String data_sign = request.getHeader("DATA_SIGN");

		// 循环出枚举的code
		SignEnum signEnum = EnumUtil.getSignEnum(client_os);
		String client_os_EnumKey = null;
		if (signEnum != null) {
			client_os_EnumKey = signEnum.getKey();
		}

		// 1.签名 签名算法: dataSign=MD5(REQUEST_TIME的值+”|&|”+ REQUEST_ID的值+” |&|”+ CLIENT_OS的值+”|&|”+md5 key)
		String sign = TokenUtils.toMd5(request_time + "|&|" + request_id + "|&|" + client_os + "|&|" + client_os_EnumKey);

		// 2.对比
		// if (!sign.equals(data_sign)) {
		// _logger.error("签名失败");
		// return;
		// }
		/********************** 签名结束 **********************/

		if (doCheck(request, response)) {
			filterChain.doFilter(request, response);
		} else {
			_logger.error(MessageFormat.format("[doFilterInternal] - access denied [{0}]", request.getRequestURI()));
			setResponse(response);
			return;
		}
	}

	private boolean doCheck(HttpServletRequest request, HttpServletResponse response) {
		if (!checkWhitelist(request, response))
			return checkToken(request, response);
		else
			return true;
	}

	private boolean checkWhitelist(HttpServletRequest request, HttpServletResponse response) {
		boolean result = whitelistUrlChecker.check(request.getRequestURI());

		if (result)
			_logger.debug(MessageFormat.format("[checkWhitelist] - 用户可匿名访问uri:{0}", request.getRequestURI()));

		return result;
	}

	private boolean checkToken(HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader("ACCESS_TOKEN");

		if (StringUtils.isBlank(token))
			return false;

		String userId = redisService.get(PlatformConstant.USER_ACCESS_TOKEN_PREFIX + token);
		// _logger.info("redis userid = " + userId);
		// System.out.println("redis userid = " + userId);
		if (StringUtils.isEmpty(userId))
			return false;

		redisService.expire(token, RedisService.ONE_MONTH);

		bindUser(request, Integer.valueOf(userId));

		return true;
	}

	private void bindUser(HttpServletRequest request, Integer userId) {
		request.setAttribute("curr_user_id", userId);
	}

	private void setResponse(HttpServletResponse response) throws IOException {
		OutputStream os = null;
		try {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());

			os = response.getOutputStream();

			String text = JSON.toJSONString(buildErrors());

			byte[] bytes = text.getBytes("UTF-8");

			os.write(bytes);
		} catch (Exception e) {
			_logger.error("[setResponseBody] - fail to set response body", e);
		} finally {
			if (os != null)
				os.flush();
		}
	}

	private ErrorObject buildErrors() {
		return new ErrorObject("0401", "无访问权限");
	}
}
