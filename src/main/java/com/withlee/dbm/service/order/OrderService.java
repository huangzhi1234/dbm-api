
package com.withlee.dbm.service.order;

import java.util.Date;
import java.util.List;

import com.withlee.dbm.domain.order.OrderPlace;
import com.withlee.dbm.domain.order.OrderStatusVo;
import com.withlee.dbm.domain.order.vo.OrderPlaceVo;

/**
 * @desc 订单模块Service
 * @author linjiazhi
 * @since 2015年7月15日
 */
public interface OrderService {

	/**
	 * 商品下单
	 */
	public int addOrder(OrderPlace orderPlace);

	/**
	 * 取消订单
	 */
	public void delOrder(Integer userid, Integer orderid, Date date);

	/**
	 * 查询订单列表
	 */
	public List<OrderPlace> getOrderList(int page, int limit, Integer userid, String status);

	/**
	 * 查询订单详情
	 */
	public OrderPlaceVo getOrderDetail(Integer userid, Integer orderid);

	/**
	 * 修改订单状态
	 */
	public void updateOrderStatus(OrderStatusVo orderStatusVo);

}
