package com.keqi.springbooteasyexcel;

import com.alibaba.excel.EasyExcel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {

	/**
	 * 文件下载
	 * <p>1. 创建excel对应的实体对象 参照{@link DownloadData}
	 * <p>2. 设置返回的 参数
	 * <p>3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
	 */
	@GetMapping("/download")
	public void download(Customer customer, HttpServletResponse response) throws IOException {

		// 设定请求头内容
		response.setContentType("application/vnd.ms-excel");
		// 设定请求编码
		response.setCharacterEncoding("utf-8");
		// 在这里设置文件名称，但是必须是英文，因为HTTP请求头是不支持中文的哦，它是ASCII码
		//response.setHeader("Content-disposition", "attachment;filename=demo.xlsx");

		// ============测试中文文件名==============

		// 改成中文试了下，是没有用的，结果文件名变成了 _________ 这个
		// response.setHeader("Content-disposition", "attachment;filename=这里写中文会有问题吗？.xlsx");

		// 那如果我非要保证用户下载的时候下载到的是一个有具体中文命名的文档怎么办呢？
		// 其实可以通过把中文进行编码转成英文，传递给前端，然后前端再解码就行了啊，前后端约定好用什么编码方式就行
		// 直接使用java.net.URLEncoder类的encode()方法进行编码就行
		String fileName = URLEncoder.encode("文件名.xlsx", "UTF-8");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		// 经过测试，使用chrome浏览器在地址栏上输入请求地址，下载到的文件就是由中文命名的

		// ============测试GET请求同时接收参数==============
		System.out.println("接收到了参数：" + customer.toString());
		// 经过测试，这样做完美通过

		// 写入数据到excel文件中，就自动下载了
		// 其中DemoData是加了EasyExcel注解的实体类，data()方法获取的是一个List类型的列表数据
		// 这种写法，response流会自动关闭
		EasyExcel.write(response.getOutputStream(), DemoData.class).sheet("模板").doWrite(data());
	}

	private List<DemoData> data() {
		List<DemoData> list = new ArrayList<DemoData>();
		for (int i = 0; i < 1000; i++) {
			DemoData data = new DemoData();
			//data.setId((long) i);
			data.setString("字符串" + i);
			data.setDate(new Date());
			data.setDoubleData(0.56);
			list.add(data);
		}
		return list;
	}
}
