
package com.withlee.dbm.service.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.user.AccountBinding;
import com.withlee.dbm.domain.user.UserAccount;
import com.withlee.dbm.persistence.mapper.user.UserMapper;
import com.withlee.dbm.service.user.UserService;

/**
 * @desc 用户模块ServiceImpl
 * @author linjiazhi
 * @since 2015年7月11日
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserAccount getUser(String account, String userPassword) {
		return this.userMapper.getUser(account, userPassword);
	}

	@Override
	public AccountBinding getBingding(String openId) {
		return this.userMapper.getBingding(openId);
	}

	@Override
	public UserAccount getUserInfo(Integer userId) {
		return this.userMapper.getUserInfo(userId);
	}

	// 注册,往2张表插记录
	@Override
	public UserAccount addUserAndBingDing(AccountBinding accountBinding) {
		// System.out.println("插入前主键为：" + accountBinding.getUserId());
		this.userMapper.addUserAccount(accountBinding);

		// 拿到UserAccount表的user_id
		int afterUserId = accountBinding.getUserId();

		// System.out.println("插入后主键为：" + afterUserId);

		// 这里加入事务测试
		// int i = 1 / 0;
		accountBinding.setBindingTime(new Date());
		this.userMapper.addAccountBingding(accountBinding);

		return this.getUserInfo(afterUserId);
	}

	@Override
	public boolean addUserScore(Integer userId, double score) {
		return this.userMapper.addUserScore(userId,score) > 0;
	}

	@Override
	public UserAccount findByInvitationId(Integer invitationId) {
		return this.userMapper.findByInvitationId(invitationId);
	}

}
