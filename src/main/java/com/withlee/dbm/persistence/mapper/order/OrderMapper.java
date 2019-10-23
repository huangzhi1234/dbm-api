
package com.withlee.dbm.persistence.mapper.order;

import java.util.Date;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.cupboard.Vo.EcsGoodsVo;
import com.withlee.dbm.domain.order.OrderAddress;
import com.withlee.dbm.domain.order.OrderInvoice;
import com.withlee.dbm.domain.order.OrderPlace;
import com.withlee.dbm.domain.order.OrderProduct;
import com.withlee.dbm.domain.order.OrderStatusVo;
import com.withlee.dbm.domain.order.vo.OrderPlaceVo;

/**
 * @desc 订单模块 Mapper
 * @author linjiazhi
 * @since 2015年7月15日
 */
public interface OrderMapper {

	/************** 下单流程开始 **************/
	// 1. 下单第1步:往订单表插记录,返回tbl_order_info表的order_id
	public int addOrder(OrderPlace orderPlace);

	// 2. 下单第2步 :循环插入订单商品表
	public void addOrderProduct(OrderProduct orderProduct);

	// 3. 下单第3步:插入订单地址
	public void addOrderAddress(OrderAddress orderAddress);

	// 4. 下单第4步:插入订单发票信息
	public void addOrdeInvoice(OrderInvoice orderInvoice);
	/************** 下单流程结束 **************/

	/**
	 * 取消订单
	 */
	public void delOrder(@Param("userid") Integer userid, @Param("orderid") Integer orderid, @Param("date") Date date);

	/**
	 * 查询订单列表接口
	 */
	public List<OrderPlace> getOrderList(@Param("page") int page, @Param("limit") int limit, @Param("userid") Integer userid,
			@Param("status") String status);

	/**
	 * 统计订单列表页数
	 */
	public int countOrderList(@Param("page") int page, @Param("limit") int limit, @Param("userid") Integer userid,
			@Param("status") String status);

	/********* 查询订单详情开始 ***********/
	// 1. 获取订单信息
	public OrderPlaceVo getOrderDetail(@Param("userid") Integer userid, @Param("orderid") Integer orderid);

	// 2. 获取订单商品
	public List<OrderProduct> getOrderProduct(@Param("orderid") Integer orderid);

	/********* 查询订单详情结束 ***********/

	// 私人衣橱.获取订单商品
	public List<EcsGoodsVo> getOrderProductByUserId(@Param("userId") Integer userId, @Param("sceneName") String sceneName,
			@Param("goodsId") String goodsId);

	/**
	 * 修改订单状态
	 */
	public void updateOrderStatus(OrderStatusVo orderStatusVo);

	/**
	 * 查订单收货地址
	 */
	public OrderAddress getOrderAddress(int orderId);

	/**
	 * 查询订单详情(支付宝使用)
	 */
	public OrderPlaceVo getOrderDetailByNum(String orderNum);

}
