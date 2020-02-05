package com.keqi.springbooteasyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DemoData {

	// 这个类上面不加注解，会不会被导入到Excel中呢？
	// 结果让人感觉非常不幸，会被导入到Excel注解中
	// 解决方案是，专门为Excel导出创建一个类哦
	// 不要在内存中做转换，而是直接就用这个类接收数据库中的数据
	private Long id;

	@ExcelProperty("字符串标题")
	private String string;
	@ExcelProperty("日期标题")
	private Date date;
	@ExcelProperty("数字标题")
	private Double doubleData;

}
