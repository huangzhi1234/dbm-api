package com.withlee.dbm.service.common;

import com.withlee.dbm.domain.common.Version;

/**
 * @desc 版本更新Service
 * @author linjiazhi
 * @since 2015年8月25日
 */
public interface VersionService {

	/**
	 * 版本升级
	 */
	public Version updateDeviceVersion(String deviceId);

	/**
	 * 数据库更新
	 */
	public Version updateDBVersion(String deviceId);
}
