package com.keqi.springbootmvcjackson.domain;

import com.keqi.springbootmvcjackson.enums.GenderEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Student {

	private String name;

	// 可见，直接在实体类属性上加注解，是可以生效的，
	// @JsonDeserialize(using = BigDecimalDeSerialize.class)
	// @JsonSerialize(using = BigDecimalSerialize.class)
	private BigDecimal score;

	// 默认情况下，jackson 序列化时，输出的是 name() 方法
	// 默认情况情况下，jackson 反序列化时，支持 ordinal 属性和 name 属性两种序列化机制
	// @JsonDeserialize(using = BaseEnumDeSerializer.class)
	// @JsonSerialize(using = BaseEnumSerializer.class)

	// 在实体类上加注解，已经实现了，全局还没有实现，再继续找找解决方案
	private GenderEnum gender;
}
