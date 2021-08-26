package com.keqi.seed.core.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * MyBatisPlus 配置类
 *
 * @author keqi
 */
@MapperScan("com.keqi")
@Configuration
public class MyBatisPlusConfig implements MetaObjectHandler {

	/**
	 * 新增时自动填充字段，此段代码想要执行需满足以下 3 个条件：
	 * 1)此字段未手动填充值
	 * 2)DO中必须存在名称为 updateTime/createTime 的字段，且类型为 LocalDateTime
	 * 3)DO中此字段设置了 @TableField 注解的 fill 属性为 FieldFill.INSERT 或者 FieldFill.INSERT_UPDATE
	 *
	 * @param metaObject metaObject
	 */
	@Override
	public void insertFill(MetaObject metaObject) {
		this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
		this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
	}

	/**
	 * 修改时自动填充字段，此段代码想要执行需满足以下 3 个条件：
	 * 1)此字段未手动填充值
	 * 2)DO中必须存在名称为 updateTime 的字段，且类型为 LocalDateTime
	 * 3)DO中此字段设置了 @TableField 注解的 fill 属性为 FieldFill.UPDATE 或者 FieldFill.INSERT_UPDATE
	 *
	 * @param metaObject metaObject
	 */
	@Override
	public void updateFill(MetaObject metaObject) {
		this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
	}

	/**
	 * MyBatisPlus 分页插件配置
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		return interceptor;
	}
}
