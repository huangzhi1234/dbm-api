package com.withlee.dbm.util.authenticate;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

@Component("whitelistUrlChecker")
public class WhitelistUrlChecker implements UrlChecker {

	private static final Logger _logger = LoggerFactory.getLogger(WhitelistUrlChecker.class);

	private Resource configfile;

	private List<String> patterns;

	private PathMatcher matcher = new AntPathMatcher();

	public WhitelistUrlChecker() throws Exception {
		this("whitelist");
	}

	public WhitelistUrlChecker(String location) throws Exception {
		this.patterns = new CopyOnWriteArrayList<String>();
		this.configfile = new ClassPathResource(location);

		try {
			loadConfigs();
		} catch (Exception e) {
			_logger.error("fail to load configs", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	private void loadConfigs() throws Exception {
		if (this.configfile == null)
			throw new IllegalArgumentException("config file could not be null , please check.");

		List<String> lines = IOUtils.readLines(this.configfile.getInputStream(), "UTF-8");

		if (lines != null && lines.size() != 0) {
			Iterator<String> iterator = lines.iterator();

			while (iterator.hasNext()) {
				this.patterns.add(iterator.next());
			}
		}
	}

	@Override
	public boolean check(String uri) {
		if (StringUtils.isBlank(uri))
			return false;

		for (String pattern : patterns) {
			if (doMatch(pattern, uri))
				return true;
		}

		return false;
	}

	private boolean doMatch(String pattern, String uri) {
		return matcher.match(pattern, uri);
	}
}
