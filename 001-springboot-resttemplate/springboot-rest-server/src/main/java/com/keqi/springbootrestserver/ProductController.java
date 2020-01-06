package com.keqi.springbootrestserver;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/product")
@RestController
public class ProductController {

	//==============GET请求====================//

	// 根据id查询对应的产品记录(url路径传输参数)
	@GetMapping("/{id}")
	public AjaxEntity getProduct1(@PathVariable Integer id) {
		return AjaxEntity.success(new Product(id, "ProductA", 6666.0));
	}

	// 根据id和name查询指定记录(url?后缀传输参数)
	@GetMapping("/")
	public AjaxEntity getProduct2(Integer id, String name) {
		return AjaxEntity.success(new Product(id, name, 6666.0));
	}


	//==============POST请求====================//

	// 请求体中拼接字符串传递参数(post/put都一样)
	@PostMapping("/")
	public AjaxEntity postProduct1(Product product) {
		return AjaxEntity.success(product);
	}

	// 请求体中传递json数据(post/put都一样)
	@PostMapping("/json")
	public AjaxEntity postProduct2(@RequestBody Product product) {
		return AjaxEntity.success(product);
	}

	//==============DELETE请求====================//

	// delete方法传递url路径参数(其实和get是一样的)
	@DeleteMapping("/{id}")
	public AjaxEntity delete(@PathVariable Integer id) {
		System.out.println(String.format("编号为%s的产品删除成功", id));
		return AjaxEntity.success();
	}

	//==============POST文件上传请求====================//

	@PostMapping("/upload")
	public AjaxEntity upload(MultipartFile file, String name) {
		String originalFilename = file.getOriginalFilename();
		String value = "upload success filename: " + originalFilename + ": " + name;
		Map<String, Object> ret = new HashMap<>();
		ret.put("fileName", value);
		return AjaxEntity.success(ret);
	}
}

