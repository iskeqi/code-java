package com.keqi.apihu.core.config;

import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Configuration
@EnableTransactionManagement
@MapperScan("com.keqi.apihu.**.mapper")
public class MybatisPlusConfig {

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

		// 开启 count 的 join 优化,只针对 left join !!!
		paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
		// 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
		paginationInterceptor.setOverflow(false);
		// 设置最大单页限制数量，默认 500 条，-1 不受限制
		paginationInterceptor.setLimit(500);

		// 动态表名配置
		DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
		dynamicTableNameParser.setTableNameHandlerMap(this.getTaableNameHandleMap());
		paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));

		return paginationInterceptor;
	}

	private Map<String, ITableNameHandler> getTaableNameHandleMap() {
		Map<String, ITableNameHandler> iTableNameHandlerMap = new HashMap<>();
		iTableNameHandlerMap.put("user", (metaObject, sql, tableName) -> {
			// metaObject 可以获取传入参数，这里实现你自己的动态规则
			String year = "_2018";
			int random = new Random().nextInt(10);
			if (random % 2 == 1) {
				year = "_2019";
			}
			return tableName + year;
		});
		return iTableNameHandlerMap;
	}
}
