package com.keqi.springbootrestclient;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Collections;
import java.util.Map;

@SpringBootTest
class SpringbootRestClientApplicationTests {

	// 配置了HttpClient的配置类后，直接注入RestTemplate对象就可以了
	// 不需要像下面一样每个方法都声明一个RestTemplate对象了哦
	@Autowired
	RestTemplate restTemplate;


	/**
	 * 响应示例：
	 * {
	 *     "status": "success",
	 *     "msg": "200",
	 *     "body": {
	 *         "id": 1,
	 *         "name": "ProductA",
	 *         "price": 6666
	 *     }
	 * }
	 */
	@Test
	void getProduct1() {
		// 1、restTemplate对象初始化(ClientHttpRequestFactory实现类有很多可以配置的地方哦，需要好好了解一下，比如超时时间，线程池大小等等)
		//RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());


		// 2、请求参数的封装(包括url，请求体，请求头)
		String url = "http://localhost:8090/product/{id}";
		// url中的变量可以利用exchange()的重载方法进行替换，也可以自己使用StringUtil来在外面替换(建议后者,这样比较好封装)
		String uri = StrUtil.replace(url, "{id}", "1");


		// 3、执行Http请求
		ResponseEntity<Map> ret = restTemplate.exchange(uri, HttpMethod.GET, null, Map.class);


		// 4、响应体的解析
		if (!HttpStatus.OK.equals(ret.getStatusCode()) ||
				!"200".equals(MapUtil.getStr((Map<?, ?>) ret.getBody(), "status"))) {
			// 如果HTTP响应码不等于200,或者响应体中的status不等于200，就直接抛出异常，因为请求不成功
			// 做的更细致一点的话，这里应该去判断错误码是不是未登陆，如果未登陆就先登陆，
			// 再一次重新执行请求(这样就能够始终保持登陆状态了，这个封装非常的有必要)
			throw new RuntimeException();
		}
		Product product = BeanUtil.mapToBean(MapUtil.get(ret.getBody(), "body", Map.class),
				Product.class, true);


		System.out.println("请求成功:" + product);
	}


	/**
	 * 响应示例：
	 * {
	 *     "status": "success",
	 *     "msg": "200",
	 *     "body": {
	 *         "id": 1,
	 *         "name": "ProductA",
	 *         "price": 6666
	 *     }
	 * }
	 */
	@Test
	void getProduct2() {
		// 1、restTemplate对象初始化(ClientHttpRequestFactory实现类有很多可以配置的地方哦，需要好好了解一下，比如超时时间，线程池大小等等)
		//RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());


		// 2、请求参数的封装(包括url，请求体，请求头)(可见，请求头中的占位符使用的是"{}"哦)
		String url = "http://localhost:8090/product/?id={id}&name={name}";
		/*String url2 = StrUtil.replace(url, "{id}", "1");
		String url3 = StrUtil.replace(url2, "{name}", "keqi");*/

		// 3、执行Http请求
		ResponseEntity<Map> ret = restTemplate.exchange(url, HttpMethod.GET, null, Map.class,
				1,"keqi");


		// 4、响应体的解析
		if (!HttpStatus.OK.equals(ret.getStatusCode()) ||
				!"200".equals(MapUtil.getStr((Map<?, ?>) ret.getBody(), "status"))) {
			// 如果HTTP响应码不等于200,或者响应体中的status不等于200，就直接抛出异常，因为请求不成功
			// 做的更细致一点的话，这里应该去判断错误码是不是未登陆，如果未登陆就先登陆，
			// 再一次重新执行请求(这样就能够始终保持登陆状态了，这个封装非常的有必要)
			throw new RuntimeException();
		}
		Product product = BeanUtil.mapToBean(MapUtil.get(ret.getBody(), "body", Map.class),
				Product.class, true);


		System.out.println("请求成功:" + product);
	}

	/**
	 * 响应示例：
	 * {
	 *     "status": "success",
	 *     "msg": "200",
	 *     "body": {
	 *         "id": 1,
	 *         "name": "ProductA",
	 *         "price": 6666
	 *     }
	 * }
	 */
	@Test
	void postProduct1() {
		// 1、restTemplate对象初始化(ClientHttpRequestFactory实现类有很多可以配置的地方哦，
		// 需要好好了解一下，比如超时时间，线程池大小等等)
		//RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());


		// 1、请求参数的封装(包括url，请求体，请求头)
		String url = "http://localhost:8090/product/";
		// 设置请求头
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		// 设置请求体内容(如果不通过map的方式写请求体的参数，那么就需要自己拼接字符串，然后设置到请求体HttpEntity对象中)
		MultiValueMap<String, Object> bodyParam = new LinkedMultiValueMap<>();
		bodyParam.add("id", 1);
		bodyParam.add("name", "keqi");
		bodyParam.add("price", 4899.6);
		HttpEntity<MultiValueMap> httpEntity = new HttpEntity<>(bodyParam, header);

		// 2、执行Http请求
		ResponseEntity<Map> ret = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

		// 3、响应体的解析
		if (!HttpStatus.OK.equals(ret.getStatusCode()) ||
				!"200".equals(MapUtil.getStr((Map<?, ?>) ret.getBody(), "status"))) {
			// 如果HTTP响应码不等于200,或者响应体中的status不等于200，就直接抛出异常，因为请求不成功
			// 做的更细致一点的话，这里应该去判断错误码是不是未登陆，如果未登陆就先登陆，
			// 再一次重新执行请求(这样就能够始终保持登陆状态了，这个封装非常的有必要)
			throw new RuntimeException();
		}
		Product product = BeanUtil.mapToBean(MapUtil.get(ret.getBody(), "body", Map.class),
				Product.class, true);


		System.out.println("请求成功:" + product);
	}

	/**
	 * 响应示例：
	 * {
	 *     "status": "success",
	 *     "msg": "200",
	 *     "body": {
	 *         "id": 1,
	 *         "name": "ProductA",
	 *         "price": 6666
	 *     }
	 * }
	 */
	@Test
	void postProduct2() {
		// 1、restTemplate对象初始化(ClientHttpRequestFactory实现类有很多可以配置的地方哦，
		// 需要好好了解一下，比如超时时间，线程池大小等等)
		//RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());


		// 2、请求参数的封装(包括url，请求体，请求头)
		String url = "http://localhost:8090/product/json";
		// 设置请求头
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		header.put(HttpHeaders.ACCEPT, Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));
		// 设置请求体内容(直接设置一个对象即可，如果请求参数个数比较少，也可以设置为Map)
		// 底层会使用jackson去转换成json，放到请求体中的(其实是根据header中设置的信息来决定要如何组织请求内容)
		Product p = new Product();
		p.setId(1);
		p.setName("keqi");
		p.setPrice(4899.5);
		HttpEntity<Product> httpEntity = new HttpEntity<>(p, header);

		// 3、执行Http请求
		ResponseEntity<Map> ret = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);


		// 4、响应体的解析
		if (!HttpStatus.OK.equals(ret.getStatusCode()) ||
				!"200".equals(MapUtil.getStr((Map<?, ?>) ret.getBody(), "status"))) {
			// 如果HTTP响应码不等于200,或者响应体中的status不等于200，就直接抛出异常，因为请求不成功
			// 做的更细致一点的话，这里应该去判断错误码是不是未登陆，如果未登陆就先登陆，
			// 再一次重新执行请求(这样就能够始终保持登陆状态了，这个封装非常的有必要)
			throw new RuntimeException();
		}
		Product product = BeanUtil.mapToBean(MapUtil.get(ret.getBody(), "body", Map.class),
				Product.class, true);


		System.out.println("请求成功:" + product);
	}

	/**
	 * 响应示例：
	 * {
	 *     "status": "success",
	 *     "msg": "200",
	 *     "body": {}
	 * }
	 */
	@Test
	void delete() {
		// 1、restTemplate对象初始化(ClientHttpRequestFactory实现类有很多可以配置的地方哦，需要好好了解一下，比如超时时间，线程池大小等等)
		//RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());


		// 2、请求参数的封装(包括url，请求体，请求头)
		String url = "http://localhost:8090/product/{id}";

		// 3、执行Http请求
		ResponseEntity<Map> ret = restTemplate.exchange(url, HttpMethod.DELETE, null, Map.class, 1);

		// 4、响应体的解析
		if (!HttpStatus.OK.equals(ret.getStatusCode()) ||
				!"200".equals(MapUtil.getStr((Map<?, ?>) ret.getBody(), "status"))) {
			// 如果HTTP响应码不等于200,或者响应体中的status不等于200，就直接抛出异常，因为请求不成功
			// 做的更细致一点的话，这里应该去判断错误码是不是未登陆，如果未登陆就先登陆，
			// 再一次重新执行请求(这样就能够始终保持登陆状态了，这个封装非常的有必要)
			throw new RuntimeException();
		}

		System.out.println("请求成功:");
	}

	/**
	 * 响应示例：
	 * {
	 *     "status": "success",
	 *     "msg": "200",
	 *     "body": {
	 *         "fileName": "fs"
	 *     }
	 * }
	 */
	@Test
	void upload() {
		// 1、restTemplate对象初始化(ClientHttpRequestFactory实现类有很多可以配置的地方哦，
		// 需要好好了解一下，比如超时时间，线程池大小等等)
		//RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());


		// 2、请求参数的封装(包括url，请求体，请求头)
		String url = "http://localhost:8090/product/upload";
		// 设置请求头
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		header.add(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE);
		// 设置请求内容
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		FileSystemResource file = new FileSystemResource(new File("D:\\1.txt"));
		body.add("file", file);
		body.add("name", "keqi");
		HttpEntity<MultiValueMap> httpEntity = new HttpEntity<>(body, header);

		// 3、执行Http请求
		ResponseEntity<Map> ret = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);


		// 4、响应体的解析
		if (!HttpStatus.OK.equals(ret.getStatusCode()) ||
				!"200".equals(MapUtil.getStr((Map<?, ?>) ret.getBody(), "status"))) {
			// 如果HTTP响应码不等于200,或者响应体中的status不等于200，就直接抛出异常，因为请求不成功
			// 做的更细致一点的话，这里应该去判断错误码是不是未登陆，如果未登陆就先登陆，
			// 再一次重新执行请求(这样就能够始终保持登陆状态了，这个封装非常的有必要)
			throw new RuntimeException();
		}
		String fileName = MapUtil.get(MapUtil.get(ret.getBody(), "body", Map.class),
				"fileName", String.class);

		System.out.println("请求成功:" + fileName);
	}

	// 至此，RestTemplate对象的相关API都已经挨个体验过了，实际项目中用到了，过来参考一下，然后封装一下就没有问题了

	// 实际项目中去对接具体第三方API时，不同第三方或多或少会不一样。但是，同一个第三方的API肯定是一样的，可以根据具体情况
	// 决定这个封装的程度要做到多大。比如有的直接把请求头固定为application/json了，这个可以封装，有的不同接口都不一样
	// (有时是json有时是表单等)，那么就不必封装


	// 遗留下来的问题就是ClientHttpRequestFactory工厂对象的相关配置，比如超时时间，线程池大小等等啦
	// 这也是一个必须要掌握的内容，阅读一遍下面这个文章，然后直接复制粘贴过来就行了(https也是支持的)
	// 做一个全局的配置，其他需要用到RestTemplate的地方，就直接注入进来就可以了
	// 参考：https://howtodoinjava.com/spring-boot2/resttemplate/resttemplate-httpclient-java-config/

	// 已经在config包下配置好了，直接拷贝就行了

}
