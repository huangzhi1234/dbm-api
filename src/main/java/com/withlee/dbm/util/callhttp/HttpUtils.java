package com.withlee.dbm.util.callhttp;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.Response;

public class HttpUtils {

	private static final Logger _logger = LoggerFactory.getLogger(HttpUtils.class);

	public static Object doAsyncGet(String url) {
		return doAsyncGet(url, null);
	}

	public static Object doAsyncGet(String url, Map<String, String> params) {
		return doAsyncGet(url, null, params);
	}

	public static Object doAsyncPost(String url, Map<String, String> params) {
		return doAsyncPost(url, null, params, null);
	}

	public static Object doAsyncPost(String url, Object object) {
		return doAsyncPost(url, null, null, object);
	}

	public static Object doAsyncGet(String url, Map<String, String> headers, Map<String, String> params) {
		try {
			AsyncHttpClient.BoundRequestBuilder builder = AsyncHttpClientHelper.getHttpClient().prepareGet(url);

			buildHeaders(builder, headers);
			buildParams(builder, params);

			Future<Response> f = builder.execute();

			Response response = f.get();

			if (response.getStatusCode() == 200)
				return onSuccess(response.getResponseBodyAsStream());
		} catch (Exception e) {
			_logger.error("[doAsyncGet] - fail to do async http get , exception is " + e.getMessage(), e);
		}

		return null;
	}

	public static Object doAsyncPost(String url, Map<String, String> headers, Map<String, String> params, Object body) {
		try {
			AsyncHttpClient.BoundRequestBuilder builder = AsyncHttpClientHelper.getHttpClient().preparePost(url);

			builder.addHeader("Content-Type", "application/json");

			buildHeaders(builder, headers);
			buildParams(builder, params);
			buildBody(builder, body);

			Future<Response> f = builder.execute();

			Response response = f.get();

			_logger.info("response status code = " + response.getStatusCode());

			if (response.getStatusCode() == 200 || response.getStatusCode() == 201)
				return onSuccess(response.getResponseBodyAsStream());
			else
				throw new Exception("fail to call http " + IOUtils.toString(response.getResponseBodyAsStream()));
		} catch (Exception e) {
			e.printStackTrace();
			_logger.error("[doAsyncPost] - fail to do async http get , exception is " + e.getMessage(), e);
		}

		return null;
	}

	private static void buildParams(BoundRequestBuilder builder, Map<String, String> kvs) {
		if (kvs == null || kvs.isEmpty())
			return;

		Iterator<String> iterator = kvs.keySet().iterator();

		while (iterator.hasNext()) {
			String k = iterator.next();
			String v = kvs.get(k);

			builder.addQueryParam(k, v);
		}
	}

	private static void buildHeaders(BoundRequestBuilder builder, Map<String, String> kvs) {
		if (kvs == null || kvs.isEmpty())
			return;

		Iterator<String> iterator = kvs.keySet().iterator();

		while (iterator.hasNext()) {
			String k = iterator.next();
			String v = kvs.get(k);

			builder.addHeader(k, v);
		}
	}

	private static void buildBody(BoundRequestBuilder builder, Object body) throws Exception {
		if (body == null)
			return;

		builder.setBody(JSONObject.toJSONString(body));
	}

	private static Object onSuccess(InputStream is) throws Exception {
		String result = IOUtils.toString(is);

		try {
			return JSONObject.parseObject(result);
		} catch (Exception e) {
			return JSONArray.parse(result);
		}

	}

}
