
package com.withlee.dbm.controller.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.withlee.dbm.domain.order.TblUserAddress;
import com.withlee.dbm.persistence.mapper.order.AddressMapper;
import com.withlee.dbm.service.order.AddressService;
import com.withlee.dbm.util.response.CommonResponse;

/**
 * @desc 收货地址Controller
 * @author linjiazhi
 * @since 2015年7月17日
 */
@RestController
@RequestMapping("/address")
public class AddressController {

	private static Logger logger = LoggerFactory.getLogger(AddressController.class);

	@Autowired
	private AddressService addressService;
	@Autowired
	private AddressMapper addressMapper;

	/**
	 * 查询收货地址(单个)
	 */
	@RequestMapping(value = "/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getAddress(@PathVariable Integer userid, @RequestParam(value = "addressId", required = false) Integer addressId)
			throws IOException {

		try {
			return new CommonResponse(this.addressService.getAddress(userid, addressId));
		} catch (Exception e) {
			logger.error("[getAddress] - fail to getAddress " + e.getMessage());
			return new CommonResponse("查询收货地址失败");
		}
	}

	/**
	 * 查询地址列表
	 */
	@RequestMapping(value = "/list/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getAddressList(@PathVariable Integer userid) throws Exception {
		try {
			return new CommonResponse(this.addressService.getAddressList(userid));
		} catch (Exception e) {
			logger.error("[getAddressList] - fail to getAddressList " + e.getMessage());
			return new CommonResponse("查询收货地址列表异常");
		}

	}
	
	/**
	 * test
	 */
	@RequestMapping(value = "/getData/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getTestData(@PathVariable Integer userid) throws Exception {
		try {
			List<TblUserAddress>  list =new ArrayList();
			TblUserAddress tblUserAddress=new TblUserAddress();
			tblUserAddress.setAddress("333");
			tblUserAddress.setAddressId(11);
			tblUserAddress.setCity("99");
			list.add(tblUserAddress);			
			return new CommonResponse(list);
		} catch (Exception e) {
			logger.error("[getAddressList] - fail to getAddressList " + e.getMessage());
			return new CommonResponse("查询收货地址列表异常");
		}

	}

	/**
	 * 增加收货地址
	 */
	@RequestMapping(value = "/add/{userid}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public CommonResponse addAddress(@PathVariable Integer userid, @RequestBody TblUserAddress tblUserAddress) throws Exception {

		try {
			tblUserAddress.setUserId(userid);
			// 清空用户现有默认地址
			if (tblUserAddress.getIsDefault() != null && tblUserAddress.getIsDefault() == 1) {
				this.addressMapper.updateIsDefault(tblUserAddress.getUserId());
			}

			return new CommonResponse(this.addressService.addAddress(tblUserAddress));
		} catch (Exception e) {
			logger.error("[addAddress] - fail to addAddress " + e.getMessage());
			return new CommonResponse("新增收货地址失败");
		}
	}

	/**
	 * 修改收货地址
	 */
	//
	@RequestMapping(value = "/update/{userid}", method = RequestMethod.PUT)
	@ResponseBody
	public CommonResponse updateAddress(@PathVariable Integer userid, @RequestBody TblUserAddress tblUserAddress) throws IOException {
		try {
			tblUserAddress.setUserId(userid);
			return new CommonResponse(this.addressService.updateAddress(tblUserAddress));
		} catch (Exception e) {
			logger.error("[updateAddress] - fail to updateAddress " + e.getMessage());
			return new CommonResponse("更新收货地址失败");
		}
	}

	/**
	 * 删除收货地址
	 */
	@RequestMapping(value = "/delete/{userid}/{addressid}", method = RequestMethod.DELETE)
	@ResponseBody
	public CommonResponse delAddress(@PathVariable Integer userid, @PathVariable Integer addressid) throws IOException {

		try {
			return new CommonResponse(this.addressService.delAddress(userid, addressid));
		} catch (Exception e) {
			logger.error("[delAddress] - fail to delAddress " + e.getMessage());
			return new CommonResponse("删除收货地址失败");
		}
	}

}
