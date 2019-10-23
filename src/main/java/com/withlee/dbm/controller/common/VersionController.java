package com.withlee.dbm.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.withlee.dbm.domain.common.Version;
import com.withlee.dbm.service.common.VersionService;

/**
 * @desc 版本更新Controller
 * @author linjiazhi
 * @since 2015年8月25日
 */
@RestController
@RequestMapping("/version")
public class VersionController {

	@Autowired
	private VersionService service;

	/**
	 * 版本升级
	 *
	 * @param deviceId=设备号
	 */
	@RequestMapping(value = "/device/{deviceId}", method = RequestMethod.GET)
	public Version updateDeviceVersion(@PathVariable String deviceId) {
		try {
			Version updateVersion = this.service.updateDeviceVersion(deviceId);
			return updateVersion;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 数据库更新
	 *
	 * @param deviceId=设备号
	 */
	@RequestMapping(value = "/db/{deviceId}", method = RequestMethod.GET)
	public Version updateDBVersion(@PathVariable String deviceId) {
		Version updateVersion = this.service.updateDBVersion(deviceId);
		return updateVersion;
	}
}
