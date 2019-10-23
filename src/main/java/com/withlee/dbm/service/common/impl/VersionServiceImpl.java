package com.withlee.dbm.service.common.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.common.Version;
import com.withlee.dbm.persistence.mapper.common.VersionMapper;
import com.withlee.dbm.service.common.VersionService;

/**
 * @desc 版本更新ServiceImpl
 * @author linjiazhi
 * @since 2015年8月25日
 */
@Service
@Transactional
public class VersionServiceImpl implements VersionService {

	@Autowired
	private VersionMapper versionMapper;

	/**
	 * 版本更新
	 */
	@Override
	public Version updateDeviceVersion(String deviceId) {
		// 返回最大类型
		return this.versionMapper.updateDeviceVersion(deviceId);
	}

	/**
	 * 数据库更新
	 */
	@Override
	public Version updateDBVersion(String deviceId) {
		// 返回最大类型
		return this.versionMapper.updateDBVersion(deviceId);
	}
}
