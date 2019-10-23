package com.withlee.dbm.persistence.mapper.common;

import com.withlee.dbm.domain.common.Version;

/**
 * @desc 版本更新Mapper
 * @author linjiazhi
 * @since 2015年8月25日
 */
public interface VersionMapper {

	/**
	 * 版本更新 返回最大类型
	 */
	public Version updateDeviceVersion(String deviceId);

	/**
	 * 数据库更新 返回最大类型
	 */
	public Version updateDBVersion(String deviceId);
}
