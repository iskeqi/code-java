package com.keqi.springbooteasyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.converterWrite();
	}

	/**
	 * 最简单的写
	 * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
	 * <p>2. 直接写即可
	 */
	public void simpleWrite() {
		// 写法1
		String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
		// 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
		// 如果这里想使用03 则 传入excelType参数即可
		EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

		// 写法2
		fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
		// 这里 需要指定写用哪个class去读
		ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
		WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
		excelWriter.write(data(), writeSheet);
		/// 千万别忘记finish 会帮忙关闭流
		excelWriter.finish();
	}

	/**
	 * 指定写入的列
	 * <p>1. 创建excel对应的实体对象 参照{@link IndexData}
	 * <p>2. 使用{@link ExcelProperty}注解指定写入的列
	 * <p>3. 直接写即可
	 */
	public void indexWrite() {
		String fileName = TestFileUtil.getPath() + "indexWrite" + System.currentTimeMillis() + ".xlsx";
		// 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
		EasyExcel.write(fileName, IndexData.class).sheet("模板").doWrite(data());
	}

	/**
	 * 复杂头写入
	 * <p>1. 创建excel对应的实体对象 参照{@link ComplexHeadData}
	 * <p>2. 使用{@link ExcelProperty}注解指定复杂的头
	 * <p>3. 直接写即可
	 */
	public void complexHeadWrite() {
		String fileName = TestFileUtil.getPath() + "complexHeadWrite" + System.currentTimeMillis() + ".xlsx";
		// 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
		EasyExcel.write(fileName, ComplexHeadData.class).sheet("模板").doWrite(data());
	}

	/**
	 * 重复多次写入
	 * <p>1. 创建excel对应的实体对象 参照{@link ComplexHeadData}
	 * <p>2. 使用{@link ExcelProperty}注解指定复杂的头
	 * <p>3. 直接调用二次写入即可
	 */
	public void repeatedWrite() {
		String fileName = TestFileUtil.getPath() + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
		// 这里 需要指定写用哪个class去读
		ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
		WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
		// 第一次写入会创建头
		excelWriter.write(data(), writeSheet);
		// 第二次写入会在上一次写入的最后一行后面写入
		excelWriter.write(data(), writeSheet);
		/// 千万别忘记finish 会帮忙关闭流
		excelWriter.finish();
	}

	/**
	 * 日期、数字或者自定义格式转换
	 * <p>1. 创建excel对应的实体对象 参照{@link ConverterData}
	 * <p>2. 使用{@link ExcelProperty}配合使用注解{@link DateTimeFormat}、{@link NumberFormat}或者自定义注解
	 * <p>3. 直接写即可
	 */
	public void converterWrite() {
		String fileName = TestFileUtil.getPath() + "converterWrite" + System.currentTimeMillis() + ".xlsx";
		// 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
		EasyExcel.write(fileName, ConverterData.class).sheet("模板").doWrite(data());
	}

	private List<DemoData> data() {
		List<DemoData> list = new ArrayList<DemoData>();
		for (int i = 0; i < 10; i++) {
			DemoData data = new DemoData();
			data.setString("字符串" + i);
			data.setDate(new Date());
			data.setDoubleData(0.56);
			list.add(data);
		}
		return list;
	}
}
