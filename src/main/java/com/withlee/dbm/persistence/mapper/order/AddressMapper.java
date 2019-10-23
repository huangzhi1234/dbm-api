
package com.withlee.dbm.persistence.mapper.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.order.TblUserAddress;

/**
 * @desc 收货地址Impl
 * @author linjiazhi
 * @since 2015年7月17日
 */
public interface AddressMapper {

	public TblUserAddress getAddress(@Param("userid") Integer userid, @Param("addressId") Integer addressId);

	public List<TblUserAddress> getAddressList(Integer user_id);

	public int addAddress(TblUserAddress tblUserAddress);

	public void updateAddress(TblUserAddress tblUserAddress);

	public void delAddress(@Param("userid") Integer userid, @Param("addressid") Integer addressid);

	// 下单接口-检查用户收货地址是否存在(下单接口需要,返回值设置成对象.不是int)
	public TblUserAddress checkAddressExist(@Param("userid") Integer userid, @Param("addressid") Integer addressid);

	// 清空用户现有默认地址
	public void updateIsDefault(Integer userId);
}
