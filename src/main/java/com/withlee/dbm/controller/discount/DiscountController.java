
package com.withlee.dbm.controller.discount;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.withlee.dbm.domain.discount.TblEventCoupon;
import com.withlee.dbm.domain.discount.TblEventInfo;
import com.withlee.dbm.domain.discount.vo.CouponVo;
import com.withlee.dbm.service.discount.DiscountService;
import com.withlee.dbm.service.discount.IDiscountManager;
import com.withlee.dbm.util.response.CommonResponse;

/**
 * @desc 优惠码Controller
 * @author linjiazhi
 * @since 2015年8月18日
 */
@RestController
@RequestMapping("/discount")
public class DiscountController {

	private static Logger logger = LoggerFactory.getLogger(DiscountController.class);

	@Autowired
	private DiscountService discountService;
	@Autowired
	private IDiscountManager discountManager;

	/**
	 * @desc 优惠码打折
	 * @params orderAmount 总价
	 * @params couponNum 优惠码
	 */
	@RequestMapping(value = "/{orderAmount}/{couponNum}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse eventDiscount(@PathVariable Double orderAmount, @PathVariable String couponNum) throws IOException {

		try {
			// 1. 检查优惠码是否存在
			TblEventCoupon tblEventCoupon = discountService.checkCouponExist(couponNum);

			if (tblEventCoupon == null) {
				return new CommonResponse("优惠码不存在或失效");
			}
			// 2.检查优惠码是否使用
			int count = discountService.checkCouponUsed(couponNum);
			if (count > 0) {
				return new CommonResponse("优惠码已使用");
			}
			// 3.通过event_id拿活动
			TblEventInfo tblEventInfo = discountService.queryEventInfo(tblEventCoupon.getEventId());
			String eventType = tblEventInfo.getEventType();// 0: 抵现金，1: 打折
			double value = tblEventInfo.getAmount();// 现金价值 或者 折扣值
			// 4. 申请折扣算法
			DiscountMath discountMath = new DiscountMath();
			double afterOrderAmount = 0;
			if ("1".equals(eventType)) {// 抵现金
				afterOrderAmount = discountMath.subAmount(orderAmount, value);
				// eventType = "抵现金";
			} else if ("2".equals(eventType)) {// 打折
				afterOrderAmount = discountMath.disCount(orderAmount, value);
				// eventType = "打折";
			} else if (!"1".equals(eventType) && !"2".equals(eventType)) {
				return new CommonResponse("数据异常,请检查后台数据");
			}
			ModelMap m = new ModelMap();
			m.put("price", orderAmount);// 优惠前订单价格
			m.put("discountType", eventType);// 优惠类型
			m.put("discount", value);// 优惠值
			m.put("afterDiscount", afterOrderAmount);// 优惠后价格

			return new CommonResponse(m);
		} catch (Exception e) {
			logger.error("[eventDiscount] - fail to eventDiscount " + e.getMessage());
			return new CommonResponse("系统异常");
		}

	}

	/**
	 * 子龙:查询个人优惠码
	 */
	// @RequestMapping(value = "/user")
	// public CommonResponse findCouponByUser(HttpServletRequest request) {
	// Integer userId = UserUtils.getUserId(request);
	//
	// // 查询该用户拥有未使用的优惠码
	// List<TblEventCoupon> tblEventCoupons = discountService.findByUserId(userId, 0);
	//
	// // 查询所有活动
	// List<TblEventInfo> tblEventInfos = discountService.queryEventInfoAll();
	//
	// // 转换成vo
	// Collection<CouponVo> couponVos = discountManager.mapper(tblEventInfos, tblEventCoupons);
	// return new CommonResponse(couponVos);
	// }

	/**
	 * 因页面变动,重写子龙查询个人优惠码接口
	 */
	@RequestMapping(value = "/user")
	public CommonResponse findCouponByUser(HttpServletRequest request) {
		// Integer userId = UserUtils.getUserId(request);
		Integer userId = 126;
		// 查询该用户拥有未使用的优惠码
		List<CouponVo> Couponvo = discountService.findByUserId(userId, 0);
		// 回来改返回值
		return new CommonResponse(Couponvo);
	}

}
