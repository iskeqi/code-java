package com.qjzh.idomp.zjc.core.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * 自动填充字段配置类(自动设置createTime和updateTime，一劳永逸)
 * @author keqi
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
		this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
	}
}
