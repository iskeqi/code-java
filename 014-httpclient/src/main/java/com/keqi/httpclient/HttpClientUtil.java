package com.keqi.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Map;
import java.util.Set;

/**
 * HttpClient工具类(基于HttpClient实现)
 */
public class HttpClientUtil {

	private static CloseableHttpClient httpClient;

	// 与服务器建立连接的超时时间
	private static final int CONNECTION_TIMEOUT = 5000;
	// 从HttpClientConnectionManager 管理的连接池中取出连接的超时时间
	private static final int CONNECTION_REQUEST_TIMEOUT = 5000;
	// 服务器接口响应超时时间
	private static final int SOCKET_TIMEOUT = 5000;

	private static final String UTF_8 = "UTF-8";

	static {
		httpClient = HttpClients.createDefault();
	}

	/**
	 * 通过get方式发送有参请求
	 *
	 * @param url       url
	 * @param headerMap 首部字段的Map结构
	 * @return 响应体字符串对象,如果对方接口没有返回值时,会返回一个空字符串""
	 */
	public static String get(String url, Map<String, String> headerMap) throws Exception {

		// 1、构造请求对象
		HttpGet request = new HttpGet(url);
		// 2、设定请求头内容
		HttpClientUtil.setHeaders(request, headerMap);
		// 3、设定请求配置(连接超时、请求超时等)
		request.setConfig(HttpClientUtil.getRequestConfig());
		// 4、执行HTTP请求
		CloseableHttpResponse response = httpClient.execute(request);
		// 5、获取响应体内容
		HttpEntity responseEntity = response.getEntity();
		String responseBody = EntityUtils.toString(responseEntity, HttpClientUtil.UTF_8);
		// 6、关闭此次连接，使得本次底层socket连接能够被复用
		EntityUtils.consumeQuietly(responseEntity);
		return responseBody;
	}

	/**
	 * 通过post方式发送请求
	 *
	 * @param url       url
	 * @param headerMap 首部字段的Map结构
	 * @param stringBody 请求体的字符串形式
	 * @return 响应体字符串对象,如果对方接口没有返回值时,会返回一个空字符串""
	 * @throws Exception exception
	 */
	public static String post(String url, Map<String, String> headerMap, String stringBody) throws Exception {

		// 1、构造请求对象
		HttpPost request = new HttpPost(url);
		// 2、设定请求头内容
		HttpClientUtil.setHeaders(request, headerMap);
		// 3、设定请求体内容
		StringEntity stringEntity = new StringEntity(stringBody, HttpClientUtil.UTF_8);
		request.setEntity(stringEntity);
		// 4、设定请求配置(连接超时、请求超时等)
		request.setConfig(HttpClientUtil.getRequestConfig());
		// 5、执行HTTP请求
		CloseableHttpResponse response = httpClient.execute(request);
		// 6、获取响应体内容
		HttpEntity responseEntity = response.getEntity();
		String responseBody = EntityUtils.toString(responseEntity, HttpClientUtil.UTF_8);
		// 7、关闭此次连接，使得本次底层socket连接能够被复用
		EntityUtils.consumeQuietly(responseEntity);
		return responseBody;
	}

	/**
	 * 通过put方式发送请求
	 *
	 * @param url       url
	 * @param headerMap 首部字段的Map结构
	 * @param stringBody 请求体的字符串形式
	 * @return 响应体字符串对象,如果对方接口没有返回值时,会返回一个空字符串""
	 * @throws Exception exception
	 */
	public static String put(String url, Map<String, String> headerMap, String stringBody) throws Exception {

		// 1、构造请求对象
		HttpPut request = new HttpPut(url);
		// 2、设定请求头内容
		HttpClientUtil.setHeaders(request, headerMap);
		// 3、设定请求体内容
		StringEntity stringEntity = new StringEntity(stringBody, HttpClientUtil.UTF_8);
		request.setEntity(stringEntity);
		// 4、设定请求配置(连接超时、请求超时等)
		request.setConfig(HttpClientUtil.getRequestConfig());
		// 5、执行HTTP请求
		CloseableHttpResponse response = httpClient.execute(request);
		// 6、获取响应体内容
		HttpEntity responseEntity = response.getEntity();
		String responseBody = EntityUtils.toString(responseEntity, HttpClientUtil.UTF_8);
		// 7、关闭此次连接，使得本次底层socket连接能够被复用
		EntityUtils.consumeQuietly(responseEntity);
		return responseBody;
	}

	/**
	 * 通过delete方式发送请求
	 *
	 * @param url       url
	 * @param headerMap 首部字段的Map结构
	 * @return 响应体字符串对象,如果对方接口没有返回值时,会返回一个空字符串""
	 * @throws Exception exception
	 */
	public static String delete(String url, Map<String, String> headerMap) throws Exception {

		// 1、构造请求对象
		HttpDelete request = new HttpDelete(url);
		// 2、设定请求头内容
		HttpClientUtil.setHeaders(request, headerMap);
		// 3、设定请求配置(连接超时、请求超时等)
		request.setConfig(HttpClientUtil.getRequestConfig());
		// 4、执行HTTP请求
		CloseableHttpResponse response = httpClient.execute(request);
		// 5、获取响应体内容
		HttpEntity responseEntity = response.getEntity();
		String responseBody = EntityUtils.toString(responseEntity, HttpClientUtil.UTF_8);
		// 6、关闭此次连接，使得本次底层socket连接能够被复用
		EntityUtils.consumeQuietly(responseEntity);
		return responseBody;
	}

	/**
	 * 设定请求报文的首部字段
	 *
	 * @param request   请求对象
	 * @param headerMap 参数
	 */
	private static void setHeaders(HttpRequestBase request, Map<String, String> headerMap) {
		if (headerMap == null || headerMap.size() <= 0) {
			return;
		}

		Set<Map.Entry<String, String>> entries = headerMap.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			if (entry.getValue() == null) {
				continue;
			}
			request.setHeader(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * 获取RequestConfig对象
	 *
	 * @return RequestConfig
	 */
	private static RequestConfig getRequestConfig() {
		return RequestConfig.custom()
				.setConnectTimeout(HttpClientUtil.CONNECTION_TIMEOUT)
				.setConnectionRequestTimeout(HttpClientUtil.CONNECTION_REQUEST_TIMEOUT)
				.setSocketTimeout(HttpClientUtil.SOCKET_TIMEOUT)
				.build();
	}
}
