package com.withlee.dbm.util;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.withlee.dbm.Settings;

/**
 * Created by zilongye on 15/9/7.
 */
public class UrlSerializer extends JsonSerializer<String>implements ApplicationContextAware {

	private Settings settings;

	@Override
	public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		// 如果不为空则重写
		if (StringUtils.isNotBlank(s)) {
			// jsonGenerator.writeString(settings.ADMIN_API + s);
			jsonGenerator.writeString(settings.CAMIUL_URL + s);
		} else {
			jsonGenerator.writeString("");
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.settings = applicationContext.getBean("settings", Settings.class);
	}

}
