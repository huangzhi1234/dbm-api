
package com.withlee.dbm.service.order;

import java.util.List;

import com.withlee.dbm.domain.order.TblUserAddress;

/**
 * @desc 收货地址Service
 * @author linjiazhi
 * @since 2015年7月17日
 */
public interface AddressService {

	public TblUserAddress getAddress(Integer userid, Integer addressId);

	public List<TblUserAddress> getAddressList(Integer userid);

	public boolean addAddress(TblUserAddress tblUserAddress);

	public boolean updateAddress(TblUserAddress tblUserAddress);

	public boolean delAddress(Integer userid, Integer addressid);

}
