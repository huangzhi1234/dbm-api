
package com.withlee.dbm.controller.common;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.withlee.dbm.service.common.RegionService;
import com.withlee.dbm.util.response.CommonResponse;

/**
 * @desc 查询省市区
 * @author linjiazhi
 * @since 2015年8月25日
 */
@RestController
@RequestMapping("/region")
public class RegionController {

	private static Logger logger = LoggerFactory.getLogger(RegionController.class);

	@Autowired
	private RegionService regionService;

	/**
	 * 查询省
	 */
	@RequestMapping(value = "/getProvinceList", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getProvinceList() throws IOException {

		try {
			return new CommonResponse(this.regionService.getProvinceList());
		} catch (Exception e) {
			logger.error("[getProvinceList] - fail to getProvinceList " + e.getMessage());
			return new CommonResponse("系统异常");
		}

	}

	/**
	 * 查询市
	 */
	@RequestMapping(value = "/getCityByProID/{province}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getCityByProID(@PathVariable("province") String province) throws IOException {
		try {
			return new CommonResponse(this.regionService.getCityByProID(province));
		} catch (Exception e) {
			logger.error("[getCityByProID] - fail to getCityByProID " + e.getMessage());
			return new CommonResponse("系统异常");
		}

	}

	/**
	 * 查询区
	 */
	@RequestMapping(value = "/getDistrictByCityID/{province}/{city}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getDistrictByCityID(@PathVariable("province") String province, @PathVariable("city") String city)
			throws IOException {
		try {
			return new CommonResponse(this.regionService.getDistrictByCityID(province, city));
		} catch (Exception e) {
			logger.error("[getDistrictByCityID] - fail to getDistrictByCityID " + e.getMessage());
			return new CommonResponse("系统异常");
		}

	}

}
