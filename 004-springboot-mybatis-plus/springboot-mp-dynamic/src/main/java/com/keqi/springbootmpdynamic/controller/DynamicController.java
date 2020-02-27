package com.keqi.springbootmpdynamic.controller;

import com.keqi.springbootmpdynamic.domain.DataSourceBO;
import com.keqi.springbootmpdynamic.domain.UserDO;
import com.keqi.springbootmpdynamic.service.DynamicService;
import com.keqi.springbootmpdynamic.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DynamicController {

	private UserService userService;
	private DynamicService dynamicService;

	@GetMapping("/addDataSource")
	public String addDataSource() {

		// 1、向主库中插入一条记录（测试主库是否正常以及连接池有没有配置）
		UserDO userDO = new UserDO();
		userDO.setAge(12);
		userDO.setName("keqi");
		userService.save(userDO);

		// 2、新增从库数据源(存在则不新增，不存在才新增)
		DataSourceBO dataSourceBO = new DataSourceBO();
		dataSourceBO.setUrl("jdbc:mysql://47.102.124.165:3306/dynamic-slave?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8");
		dataSourceBO.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBO.setPollName("dynamic-slave");
		dataSourceBO.setUsername("root");
		dataSourceBO.setPassword("123456");
		this.dynamicService.addHikariCP(dataSourceBO);

		// 3、根据请求参数自动切换到从库数据源中并且向从库中插入一条记录（测试从库是否正常以及连接池有没有正常配置）
		this.userService.saveToSlave();

		return "success";
	}

	// 完美实验成功，非常棒哦！


}
