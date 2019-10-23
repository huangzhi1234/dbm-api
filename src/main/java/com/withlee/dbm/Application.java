package com.withlee.dbm;

import java.sql.SQLException;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.HttpPutFormContentFilter;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
		ErrorMvcAutoConfiguration.class })
@ImportResource("classpath:application-context.xml")
public class Application {

  	public static void main(String... args) throws SQLException {
		ApplicationContext context = SpringApplication.run(Application.class, args);

	}

	@Autowired
	private Settings settings;

	// httpPut方法
	@Bean
	public Filter initializeHttpPutHandler() {
		return new HttpPutFormContentFilter();
	}

	@Bean(name = "asyncHttpClient")
	public AsyncHttpClient createAsyncHttpClient() {
		AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
		builder.setRequestTimeout(settings.httpClientRequestTimeOut);
		builder.setMaxConnectionsPerHost(settings.httpClientMaxConnPerHost);
		builder.setMaxConnections(settings.httpClientMaxConnTotal);
		return new AsyncHttpClient(builder.build());
	}

}
