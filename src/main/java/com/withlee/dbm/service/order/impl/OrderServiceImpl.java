
package com.withlee.dbm.service.order.impl;

import java.util.Date;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.withlee.dbm.domain.discount.TblEventTrack;
import com.withlee.dbm.domain.order.InvoiceInfo;
import com.withlee.dbm.domain.order.OrderAddress;
import com.withlee.dbm.domain.order.OrderInvoice;
import com.withlee.dbm.domain.order.OrderPlace;
import com.withlee.dbm.domain.order.OrderProduct;
import com.withlee.dbm.domain.order.OrderStatusVo;
import com.withlee.dbm.domain.order.TblUserAddress;
import com.withlee.dbm.domain.order.vo.OrderPlaceVo;
import com.withlee.dbm.persistence.mapper.discount.DisCountMapper;
import com.withlee.dbm.persistence.mapper.order.AddressMapper;
import com.withlee.dbm.persistence.mapper.order.InvoiceMapper;
import com.withlee.dbm.persistence.mapper.order.OrderMapper;
import com.withlee.dbm.redis.RedisService;
import com.withlee.dbm.service.order.OrderService;
import com.withlee.dbm.util.constant.PlatformConstant;

/**
 * @desc 订单模块ServiceImpl
 * @author linjiazhi
 * @since 2015年7月15日
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private InvoiceMapper invoiceMapper;

	@Autowired
	private DisCountMapper disCountMapper;

	@Autowired
	private RedisService redisService;

	/**
	 * 商品下单
	 */
	@Override
	public int addOrder(OrderPlace orderPlace) {
		// 1. 插入订单表
		// System.out.println("插入前主键为：" + orderPlace.getOrderId());
		orderMapper.addOrder(orderPlace);
		int afterOrderId = orderPlace.getOrderId();
		// System.out.println("插入后主键为：" + afterOrderId);

		// 2. 批量插入订单商品表
		for (OrderProduct orderProduct : orderPlace.getOrderProductList()) {
			orderProduct.setOrderId(afterOrderId);
			orderMapper.addOrderProduct(orderProduct);
		}

		// 3. controller层已经证明地址存在,可以开始插入到订单地址表
		// 3.1拿到地址信息
		TblUserAddress tblUserAddress = addressMapper.checkAddressExist(orderPlace.getUserId(), orderPlace.getAddressId());
		OrderAddress orderAddress = new OrderAddress();
		BeanUtils.copyProperties(tblUserAddress, orderAddress);
		orderAddress.setOrderId(afterOrderId);
		orderMapper.addOrderAddress(orderAddress);

		// 到这一步证明优惠码是有效的,插入优惠码跟踪表
		if (!StringUtils.isEmpty(orderPlace.getDiscountCode())) {
			TblEventTrack tblEventTrack = new TblEventTrack();
			// 6个属性插入优惠码跟踪表
			tblEventTrack.setEventId(orderPlace.getEventId());
			tblEventTrack.setOrderId(afterOrderId);
			tblEventTrack.setUserId(orderPlace.getUserId());
			tblEventTrack.setCouponNum(orderPlace.getCouponNum());// 优惠码
			tblEventTrack.setCreateTime(new Date());
			tblEventTrack.setCouponValue(orderPlace.getCouponValue());// 优惠值 total原价格-price优惠后价格
			disCountMapper.updateCouponStatus(orderPlace.getCouponNum());
			disCountMapper.addTblEventTrack(tblEventTrack);
		}

		// 发票ID不为空,就插订单计发票表
		if (!StringUtils.isEmpty(orderPlace.getInvoiceId())) {
			InvoiceInfo invoiceInfo = invoiceMapper.getInvoice(orderPlace.getUserId(), orderPlace.getInvoiceId());
			if (invoiceInfo != null) {
				OrderInvoice orderInvoice = new OrderInvoice();
				BeanUtils.copyProperties(invoiceInfo, orderInvoice);
				orderInvoice.setOrderId(afterOrderId);
				orderInvoice.setCreateInvoiceTime(new Date());
				orderMapper.addOrdeInvoice(orderInvoice);
			}
		}

		return afterOrderId;
	}

	/**
	 * 取消订单
	 */
	@Override
	public void delOrder(Integer userid, Integer orderid, Date date) {
		orderMapper.delOrder(userid, orderid, date);
	}

	/**
	 * 查询订单列表
	 */
	public List<OrderPlace> getOrderList(int page, int limit, Integer userid, String status) {
		return orderMapper.getOrderList(page, limit, userid, status);
	};

	/**
	 * 查询订单详情
	 */
	public OrderPlaceVo getOrderDetail(Integer userid, Integer orderid) {
		OrderPlaceVo orderPlaceVo = orderMapper.getOrderDetail(userid, orderid);
		if (orderPlaceVo != null) {
			List<OrderProduct> orderProduct = orderMapper.getOrderProduct(orderid);
			orderPlaceVo.setOrderProductList(orderProduct);
			orderPlaceVo.setAddressInfo(orderMapper.getOrderAddress(orderid));
			// 1.如果物流那2个值不为空
			if (!StringUtils.isEmpty(orderPlaceVo.getLogisticsMode()) && !StringUtils.isEmpty(orderPlaceVo.getLogisticsNum())) {
				// 2.通过物流单号get redis的值出来
				String value = redisService.get(PlatformConstant.CACHED_LOGISTICS_PREFIX + orderPlaceVo.getLogisticsNum());
				// 3.如果能找到,就直接Set值到vo,并返回给客户端
				if (StringUtils.isEmpty(value)) {
					//value = new ShowApiRequest(PlatformConstant.WULIU_API_URL, "3524", "0acee59bb34a44e28abe2a3797ea27f9")
					//		.addTextPara("com", orderPlaceVo.getLogisticsMode()).addTextPara("nu", orderPlaceVo.getLogisticsNum()).post();
					// 4. 应该拿到value,flat=ture才set,这里没时间处理,默认是公司拼音和物流单号是有效的.
					redisService.set(PlatformConstant.CACHED_LOGISTICS_PREFIX + orderPlaceVo.getLogisticsNum(), value, 7200);

					orderPlaceVo.setLogisticsInfo(JSONObject.parseObject(value));
				} else {
					orderPlaceVo.setLogisticsInfo(JSONObject.parseObject(value));
				}
				// 把那2个值set到数据库
			}
			return orderPlaceVo;
		}
		return null;
	}

	/**
	 * 修改订单状态
	 */
	@Override
	public void updateOrderStatus(OrderStatusVo orderStatusVo) {
		orderMapper.updateOrderStatus(orderStatusVo);
	};

}
