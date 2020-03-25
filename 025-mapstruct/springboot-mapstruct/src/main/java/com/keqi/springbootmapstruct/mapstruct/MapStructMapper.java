package com.keqi.springbootmapstruct.mapstruct;

import com.keqi.springbootmapstruct.domain.Order;
import com.keqi.springbootmapstruct.domain.OrderQueryParam;
import com.keqi.springbootmapstruct.domain.Source;
import com.keqi.springbootmapstruct.domain.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 实际上MapStruct会检测到使用了@Mapper注解的接口，并生成对应的实现类，然后一行行的通过get/set进行属性值的替换
 *
 * debug测试转换方法时，直接进入到源码中就可以很轻松的查看到，这就是它的原理。
 */
@Mapper
public interface MapStructMapper {

	// 可以通过这种方式，少写一行代码，避免在外面需要先从工厂类中获取到对应的实现类对象
	MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

	// 属性名、类型都相同的对象转换，直接如下写一个方法即可
	// 属性名不匹配的，就直接忽略掉了
	OrderQueryParam entity2queryParam(Order order);

	// 属性名不同的时候，需要使用@Mapping注解手动的进行转换
	// 只有单个属性不同时，使用@Mapping
	@Mapping(source = "totalCount", target = "count")
	Target source2targetSingle(Source source);

	// 属性名不同的时候，需要使用@Mapping注解手动的进行转换
	// 多个属性不同时，使用@Mappings注解包含多个@Mapping注解
	@Mappings({
			@Mapping(source = "totalCount", target = "count"),
			@Mapping(source = "numSource", target = "num")
		}
	)
	Target source2targetMutil(Source source);

	// 多个对象转成一个对象

	// 不新增对象，而是去修改对象

	// 通过 java 表达式的方式进行转换

	// 自己再接口Mapper中编写default方法手动的进行转换
}
