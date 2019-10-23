
package com.withlee.dbm.persistence.mapper.user;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.user.AccountBinding;
import com.withlee.dbm.domain.user.UserAccount;

/**
 * @desc 用户模块Mapper
 * @author linjiazhi
 * @since 2015年7月11日
 */
public interface UserMapper {

	/**
	 * 登录
	 */
	public UserAccount getUser(@Param("account") String account, @Param("userPassword") String userPassword);

	/**
	 * 第三方平台账号绑定接口-获取绑定表信息
	 */
	public AccountBinding getBingding(String openId);

	/**
	 * 第三方平台账号绑定接口-获取用户表信息
	 */
	public UserAccount getUserInfo(Integer userId);

	/**
	 * 第三方平台账号绑定接口
	 */
	// 注册第一步:往User表插记录
	public int addUserAccount(AccountBinding accountBinding);

	// 注册第二步:往绑定表插记录
	public void addAccountBingding(AccountBinding accountBinding);

	public int addUserScore(@Param("userId")Integer userId,@Param("score")double score);

	public UserAccount findByInvitationId(@Param("invitationId")Integer invitationId);
}
