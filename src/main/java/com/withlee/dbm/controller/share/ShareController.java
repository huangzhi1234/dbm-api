package com.withlee.dbm.controller.share;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.withlee.dbm.Settings;
import com.withlee.dbm.domain.order.TblUserAddress;
import com.withlee.dbm.domain.share.SharedRecord;
import com.withlee.dbm.domain.share.vo.SharedRecordVo;
import com.withlee.dbm.domain.user.UserAccount;
import com.withlee.dbm.service.invite.IReceiveService;
import com.withlee.dbm.service.share.ISharedRecordService;
import com.withlee.dbm.service.user.UserService;
import com.withlee.dbm.util.UserUtils;
import com.withlee.dbm.util.response.CommonResponse;

/**
 * Created by zilongye on 15/9/5.
 */
@RequestMapping("/share")
@RestController
public class ShareController {

	private static Logger log = LoggerFactory.getLogger(ShareController.class);

	@Autowired
	private Settings settings;
	@Autowired
	private UserService userService;
	@Autowired
	private ISharedRecordService sharedRecordService;
	@Autowired
	private IReceiveService receiveService;

	@RequestMapping(value = "/download", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public CommonResponse share(HttpServletRequest request) {
		Integer userId = UserUtils.getUserId(request);
		UserAccount userAccount = userService.getUserInfo(userId);
		String title = MessageFormat.format("邀请人{0} 邀请码{1} 下载分享", userAccount.getUserName(), userAccount.getInvitationId());
		SharedRecord sharedRecord = new SharedRecord();
		sharedRecord.setUserId(userId);
		sharedRecord.setTitle(title);
		sharedRecord.setShareDevice("ios");
		sharedRecord.setBaseUrl(settings.DOWNLOAD_SHARE_URL);
		sharedRecord.setCoverUrl(settings.COVER_URL);
		sharedRecordService.addSharedRecode(sharedRecord);
		return new CommonResponse(new SharedRecordVo(sharedRecord));
	}

	@RequestMapping(value = "/download/invitation/{invitationId}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public CommonResponse invitation(@PathVariable("invitationId") Integer invitationId, @RequestBody TblUserAddress tblUserAddress,
			HttpServletRequest request) {
		Integer userId = UserUtils.getUserId(request);
		UserAccount userAccount = userService.findByInvitationId(invitationId);
		if (userAccount == null) {
			log.error("[invitation] - fail invitationId:{} userAccount not found", invitationId);
			return new CommonResponse("无效邀请码");
		}

		tblUserAddress.setUserId(userId);

		// 邀请人获取积分,邀请人领取小礼品 所以放入同一个事务
		receiveService.receive(userAccount.getUserId(), userId, tblUserAddress);

		return new CommonResponse();
	}

	@RequestMapping(value = "/download/invitation/{invitationId}", method = RequestMethod.GET)
	public CommonResponse exists(@PathVariable("invitationId") Integer invitationId, HttpServletRequest request) {
		Integer userId = UserUtils.getUserId(request);
		UserAccount userAccount = userService.findByInvitationId(invitationId);
		if (userAccount == null) {
			log.error("[invitation] - fail invitationId:{} userAccount not found", invitationId);
			return new CommonResponse("无效邀请码");
		}
		boolean flag = receiveService.exists(userId);
		if (!flag) {
			return new CommonResponse("该用户已经领取过");
		}
		return new CommonResponse();
	}
}
