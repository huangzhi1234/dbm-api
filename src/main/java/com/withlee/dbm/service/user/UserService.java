
package com.withlee.dbm.service.user;

import com.withlee.dbm.domain.user.AccountBinding;
import com.withlee.dbm.domain.user.UserAccount;

/**
 * @desc 用户模块Service
 * @author linjiazhi
 * @since 2015年7月11日
 */
public interface UserService {

	/**
	 * 登录
	 */
	public UserAccount getUser(String account, String userPassword);

	/**
	 * 第三方平台账号绑定接口-获取绑定表信息
	 */
	public AccountBinding getBingding(String openId);

	/**
	 * 第三方平台账号绑定接口-获取用户表信息
	 */
	public UserAccount getUserInfo(Integer userId);

	/**
	 * 第三方平台账号绑定接口-注册:新增用户表&绑定表信息
	 */
	public UserAccount addUserAndBingDing(AccountBinding accountBinding);

	public boolean addUserScore(Integer userId,double score);

	public UserAccount findByInvitationId(Integer invitationId);

}
