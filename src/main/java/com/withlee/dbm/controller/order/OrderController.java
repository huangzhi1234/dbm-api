
package com.withlee.dbm.controller.order;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.withlee.dbm.controller.discount.DiscountMath;
import com.withlee.dbm.domain.discount.TblEventCoupon;
import com.withlee.dbm.domain.discount.TblEventInfo;
import com.withlee.dbm.domain.order.OrderPlace;
import com.withlee.dbm.domain.order.OrderProduct;
import com.withlee.dbm.domain.order.OrderStatusVo;
import com.withlee.dbm.domain.order.vo.OrderPlaceVo;
import com.withlee.dbm.domain.shop.EcsGoods;
import com.withlee.dbm.domain.user.UserAccount;
import com.withlee.dbm.persistence.mapper.order.AddressMapper;
import com.withlee.dbm.persistence.mapper.order.OrderMapper;
import com.withlee.dbm.persistence.mapper.shop.ShopMapper;
import com.withlee.dbm.service.discount.DiscountService;
import com.withlee.dbm.service.order.OrderService;
import com.withlee.dbm.service.user.UserService;
import com.withlee.dbm.util.DateTime;
import com.withlee.dbm.util.RandomCode;
import com.withlee.dbm.util.response.CommonResponse;
import com.withlee.dbm.util.response.PageResponse;

/**
 * @desc 订单模块Controller
 * @author linjiazhi
 * @since 2015年7月15日
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	private static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private UserService userService;

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private DiscountService discountService;

	@Autowired
	private ShopMapper shopMapper;

	/**
	 * 商品下单接口
	 */
	// 逻辑:
	// 3.插订单表
	// 4.从订单表拿到订单ID,然后循环插订单产品表
	// 1.查地用户址表,如果:
	// 有记录:只对订单地址表进行VO值拷贝.
	// 没记录:通过addressId判断如果用户地址表没有记录,就报错.
	// 2.查发票表,如果:
	// 有记录:只对订单发票表进行VO值拷贝.
	// 没记录:跟地址一样,不做处理.
	@RequestMapping(value = "/addorder/{userid}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public CommonResponse addOrder(@PathVariable Integer userid, @RequestBody OrderPlace orderPlace) throws Exception {

		try {
			UserAccount userAccount = userService.getUserInfo(userid);
			if (userAccount == null) {
				logger.info("[addorder] - user is not exist");
				return new CommonResponse("找不到该用户");
			} else if (StringUtils.isEmpty(orderPlace.getAddressId())) {
				logger.info("[addorder] - addressId is null");
				return new CommonResponse("下单地址ID为空");
			} else if (orderPlace.getOrderProductList() == null || orderPlace.getOrderProductList().size() == 0) {
				logger.info("[addorder] - OrderProducts is null");
				return new CommonResponse("该订单没有商品");
			} else if (StringUtils.isEmpty(orderPlace.getOrderProductName())) {
				logger.info("[addorder] - ProductName is null");
				return new CommonResponse("商品名称为空");
			} else if (addressMapper.checkAddressExist(userid, orderPlace.getAddressId()) == null) {
				logger.info("[addorder] - user address is not exist");
				return new CommonResponse("找不到用户所在的收货地址");
			}

			// 计算订单总价
			List<OrderProduct> orderProductList = orderPlace.getOrderProductList();
			OrderProduct orderProduct;
			EcsGoods ecsGoods;
			// double sumTotal = 0;
			double totalPrice = 0;
			for (int i = 0; i < orderProductList.size(); i++) {
				orderProduct = orderProductList.get(i);
				ecsGoods = shopMapper.getSingleGoodsInfo(orderProduct.getGoodsId());
				if (ecsGoods == null) {
					logger.info("[addorder] - goods not exist");
					return new CommonResponse("商品不存在");
				}
				totalPrice += ecsGoods.getShopPrice() * orderProduct.getProductNum();// 先把订单金额
			}

			orderPlace.setTotalPrice(totalPrice);
			// System.out.println("总价已经没问题了:sumTotalPrice=" + totalPrice);

			// 如果存在优惠码,先校验,再计算折后价,否则直接set到price
			// 计算优惠码
			if (!StringUtils.isEmpty(orderPlace.getDiscountCode())) {// 再验证一次优惠码
				// 1.拿到优惠码
				String couponNum = orderPlace.getDiscountCode();
				// 1. 检查优惠码是否存在
				TblEventCoupon tblEventCoupon = discountService.checkCouponExist(couponNum);

				if (tblEventCoupon == null) {
					logger.info("[addorder] - eventCode not exist or fail");
					return new CommonResponse("优惠码不存在或失效");
				}
				// 2.检查优惠码是否使用
				int count = discountService.checkCouponUsed(couponNum);
				if (count > 0) {
					logger.info("[addorder] - eventCode Is already in use");
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
					afterOrderAmount = discountMath.subAmount(totalPrice, value);
				} else if ("2".equals(eventType)) {// 打折
					afterOrderAmount = discountMath.disCount(totalPrice, value);
				} else if (!"1".equals(eventType) && !"2".equals(eventType)) {
					logger.info("[addorder] - data exception");
					return new CommonResponse("数据异常,请检查后台数据");
				}
				// 因为是后台计算,所以不用比较传来的价格
				// if (afterOrderAmount != orderPlace.getPrice()) {
				// logger.info("[addorder] - eventCode of price exception");
				// return new CommonResponse("数据可能被篡改,客户端优惠价格计算与后台不符");
				// }

				orderPlace.setDiscountWay(eventType);

				orderPlace.setEventId(tblEventCoupon.getEventId());// 活动id

				orderPlace.setCouponNum(orderPlace.getDiscountCode());// 优惠码

				orderPlace.setCouponValue(totalPrice - afterOrderAmount); // 优惠值(优惠了多少钱)
				orderPlace.setPrice(afterOrderAmount);
			} else {
				orderPlace.setPrice(totalPrice);
			}

			orderPlace.setUserId(userid);// Mybatis不能同时参数和对象
			orderPlace.setOrderTime(new Date());// 下单时间

			// 订单状态默认1:待付款;2:待发货（已付款）;3:已发货（等待收货）;4:已完成（已收货）;5:已取消;6:已退款;
			orderPlace.setStatus(1);

			// 订单号: 代码生成,生成策略由可读的当前时间戳+4位随机数
			String orderNum = DateTime.convertDateLongToString(System.currentTimeMillis(), "yyyyMMddHHmmss")
					+ RandomCode.generateNumCode(2);
			orderPlace.setOrderNum(orderNum);

			// 罗工需要,IOS的int类型为空会报错因此下单时支付类型默认为0.by lin 2015-08-17
			// orderPlace.setPayType(0);

			// 下单成功,返回订单ID
			int orderId = orderService.addOrder(orderPlace);

			ModelMap m = new ModelMap();
			m.put("orderId", orderId);
			m.put("orderNum", orderNum);

			return new CommonResponse(m);

		} catch (

		Exception e)

		{
			logger.error("[addorder] - fail to addorder mabe params is fail" + e.getMessage());
			return new CommonResponse("商品下单异常");
		}

	}

	/**
	 * 取消订单
	 */
	@RequestMapping(value = "/delete/{userid}/{orderid}", method = RequestMethod.PUT)
	@ResponseBody
	public CommonResponse delOrder(@PathVariable Integer userid, @PathVariable Integer orderid) throws IOException {

		try {
			Date date = new Date();
			this.orderService.delOrder(userid, orderid, date);
			return new CommonResponse();
		} catch (Exception e) {
			logger.error("[delOrder] - fail to delOrder " + e.getMessage());
			return new CommonResponse("取消订单失败");
		}
	}

	/**
	 * 查询订单列表接口
	 */
	@RequestMapping(value = "/list/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getOrderList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "20") int limit, @PathVariable Integer userid, String status)
					throws Exception {
		try {
			int pageParam = (page - 1) * limit;
			// int total = orderMapper.countOrderList(pageParam, limit, userid, status);
			PageResponse pageResponse = new PageResponse(this.orderService.getOrderList(pageParam, limit, userid, status));
			pageResponse.setPage(page);
			pageResponse.setLimit(limit);
			return new CommonResponse(pageResponse);
		} catch (Exception e) {
			logger.error("[getOrderList] - fail to getOrderList " + e.getMessage());
			return new CommonResponse("查询订单列表失败");
		}
	}

	/**
	 * @desc 查询订单详情接口
	 */
	@RequestMapping(value = "/orderinfo/{userid}/{orderid}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getOrderDetail(@PathVariable Integer userid, @PathVariable Integer orderid, OrderPlace orderPlace)
			throws Exception {
		try {

			return new CommonResponse(orderService.getOrderDetail(userid, orderid));
		} catch (Exception e) {
			logger.error("[getOrderDetail] - fail to getOrderDetail " + e.getMessage());
			return new CommonResponse("查询订单明细失败");
		}
	}

	/**
	 * @desc 查询订单详情接口
	 * @desc 白名单要单独放开查询订单详情bynum给黄志的支付宝
	 */
	@RequestMapping(value = "/orderdetail/{orderNum}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getOrderDetailByNum(@PathVariable String orderNum) throws Exception {
		try {

			return new CommonResponse(orderMapper.getOrderDetailByNum(orderNum));
		} catch (Exception e) {
			logger.error("[getOrderDetailByNum] - fail to getOrderDetailByNum " + e.getMessage());
			return new CommonResponse("查询订单明细失败");
		}
	}

	/**
	 * 修改订单状态
	 */
	@RequestMapping(value = "/status/{userid}/{orderid}", method = RequestMethod.PUT)
	@ResponseBody
	public CommonResponse updateOrderStatus(@PathVariable Integer userid, @PathVariable Integer orderid,
			@RequestBody OrderStatusVo orderStatusVo) throws Exception {
		try {
			OrderPlaceVo orderPlace = orderService.getOrderDetail(userid, orderid);

			UserAccount userAccount = userService.getUserInfo(userid);
			if (userAccount == null) {
				logger.info("[updateOrderStatus] - user is not exist");
				return new CommonResponse("登录已失效,请重新登录");
			} else if (orderPlace == null) {
				logger.info("[updateOrderStatus] - orderid is not exist");
				return new CommonResponse("找不到该订单");
			} else if (orderPlace.getPayType() == 7) {
				logger.info("[updateOrderStatus] - PayType exception");
				return new CommonResponse("该订单状态已经是已取消,不能更改状态");
			}

			if (orderStatusVo.getPayType() == 5) {// 5是店铺结算
				orderStatusVo.setStatus(5);
			}
			if (orderPlace.getStatus() == 2) {// 2是已付款,4是已完成
				orderStatusVo.setStatus(4);
			} else {
				orderStatusVo.setStatus(2);
			}
			orderStatusVo.setUserid(userid);
			orderStatusVo.setOrderid(orderid);
			orderStatusVo.setDate(new Date());

			orderService.updateOrderStatus(orderStatusVo);
			return new CommonResponse();
		} catch (Exception e) {
			logger.error("[updateOrderStatus] - fail to updateOrderStatus " + e.getMessage());
			return new CommonResponse("修改订单状态失败");
		}
	}
}
