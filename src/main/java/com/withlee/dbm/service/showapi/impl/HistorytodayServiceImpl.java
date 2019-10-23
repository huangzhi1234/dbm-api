
package com.withlee.dbm.service.showapi.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.showapi.IcHistorytoday;
import com.withlee.dbm.domain.user.AccountBinding;
import com.withlee.dbm.domain.user.UserAccount;
import com.withlee.dbm.persistence.mapper.showapi.HistorytodayMapper;
import com.withlee.dbm.service.showapi.HistorytodayService;

/**
 * @desc 用户模块ServiceImpl
 * @author linjiazhi
 * @since 2015年7月11日
 */
@Service
@Transactional
public class HistorytodayServiceImpl implements HistorytodayService {

	@Autowired
	private HistorytodayMapper historytodayMapper;
	@Override
	public List<IcHistorytoday> getHistorytoday(String createtime) {
		// TODO Auto-generated method stub
		return historytodayMapper.getHistorytoday(createtime);
	}
	@Override
	public int addIcHistorytoday(IcHistorytoday icHistorytoday) {
		// TODO Auto-generated method stub
		return historytodayMapper.addIcHistorytoday(icHistorytoday);
	}

	@Override
	public AccountBinding getBingding(String openId) {
		return this.historytodayMapper.getBingding(openId);
	}

	@Override
	public UserAccount getUserInfo(Integer userId) {
		return this.historytodayMapper.getUserInfo(userId);
	}

	// 注册,往2张表插记录
	@Override
	public UserAccount addUserAndBingDing(AccountBinding accountBinding) {
		// System.out.println("插入前主键为：" + accountBinding.getUserId());
		this.historytodayMapper.addUserAccount(accountBinding);

		// 拿到UserAccount表的user_id
		int afterUserId = accountBinding.getUserId();

		// System.out.println("插入后主键为：" + afterUserId);

		// 这里加入事务测试
		// int i = 1 / 0;
		accountBinding.setBindingTime(new Date());
		this.historytodayMapper.addAccountBingding(accountBinding);

		return this.getUserInfo(afterUserId);
	}

	@Override
	public boolean addUserScore(Integer userId, double score) {
		return this.historytodayMapper.addUserScore(userId,score) > 0;
	}

	@Override
	public UserAccount findByInvitationId(Integer invitationId) {
		return this.historytodayMapper.findByInvitationId(invitationId);
	}

	@Override
	public UserAccount getUser(String account, String userPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
