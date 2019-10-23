
package com.withlee.dbm.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.order.TblUserAddress;
import com.withlee.dbm.persistence.mapper.order.AddressMapper;
import com.withlee.dbm.service.order.AddressService;

/**
 * @desc 收货地址ServiceImpl
 * @author linjiazhi
 * @since 2015年7月17日
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;

	/**
	 * 查询收货地址
	 */
	@Override
	public TblUserAddress getAddress(Integer userid, Integer addressId) {
		return this.addressMapper.getAddress(userid, addressId);
	}

	/**
	 * 获取地址列表
	 */
	@Override
	public List<TblUserAddress> getAddressList(Integer userid) {
		return this.addressMapper.getAddressList(userid);
	}

	/**
	 * 新增地址
	 */
	@Override
	public boolean addAddress(TblUserAddress tblUserAddress) {
		this.addressMapper.addAddress(tblUserAddress);
		return true;
	}

	/**
	 * 修改地址
	 */
	@Override
	public boolean updateAddress(TblUserAddress tblUserAddress) {
		this.addressMapper.updateAddress(tblUserAddress);
		return true;
	}

	/**
	 * 删除地址
	 */
	@Override
	public boolean delAddress(Integer userid, Integer addressid) {
		this.addressMapper.delAddress(userid, addressid);
		return true;
	}

}
