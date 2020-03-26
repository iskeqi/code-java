package com.keqi.springbootmapstruct.mapstruct;

import com.keqi.springbootmapstruct.domain.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 实际上MapStruct会检测到使用了@Mapper注解的接口，并生成对应的实现类，然后一行行的通过get/set进行属性值的替换
 *
 * debug测试转换方法时，直接进入到源码中就可以很轻松的查看到，这就是它的原理。
 */
@Mapper
public interface MapStructMapper {

	// 可以通过这种方式，少写一行代码，避免在外面需要先从工厂类中获取到对应的实现类对象
	// 虽然也可以通过Spring的方式声明Bean对象，但是这样是没有必要的
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

	// 多个对象转成一个对象（如果属性名相同，即便不指定是哪个类中的属性也是能够正确解析的，不同的话就必须手动指定）
	@Mapping(source = "person.description", target = "description")
	@Mapping(source = "address.houseNo", target = "houseNumber")
	DeliveryAddress personAndAddressToDeliveryAddressDto(Person person, Address address);


	// 不新增对象，而是去修改对象（这里需要加一个注解：@MappingTarget）
	// 如果真的这样的话，那干嘛不直接赋值呢？重点在于合理运用，但是不要随便去玩花样
	void updateDeliveryAddressFromAddress(Address address, @MappingTarget DeliveryAddress deliveryAddress);

	// 通过 java 表达式的方式进行转换(完美通过，只是写 java 表达式的时候一定要仔细，以防止不必要的错误发生)
	// 这里直接调用了枚举类型对象的相关方法(不需要写resource属性哦)
	// 这个在工作中用的非常频繁哦，也非常的有实际作用，要不然就直接用反射的进行对象的赋值了
	// 以后VO的转换就这样写哦，如果更复杂的话，就可以直接在接口中写default方法，自己是手动实现
	@Mapping(target = "userType", expression = "java(userDO.getUserType().name())")
	@Mapping(target = "userTypeName", expression = "java(userDO.getUserType().getValueName())")
	UserVO userDO2UserVO(UserDO userDO);

	// 自己在接口Mapper中编写default方法手动的进行转换(MapStruct其实也就是这个原理啊，哈哈哈)
	// 这里必须要使用 static 关键字进行修饰，才能够直接通过"接口.方法"的方式进行调用
	static Target manualSourceToTarget(Source source) {
		if (source == null) {
			return null;
		}
		Target target = new Target();
		target.setId(source.getId());
		target.setNum(source.getNumSource());
		target.setCount(source.getTotalCount());
		return target;
	}

	// List类型的列表进行转换
	// 属性名、类型都相同的对象转换，直接如下写一个方法即可
	// 属性名不匹配的，就直接忽略掉了
	List<OrderQueryParam> entityList2queryParamList(List<Order> order);


	// 通过 java 表达式的方式进行转换(完美通过，只是写 java 表达式的时候一定要仔细，以防止不必要的错误发生)
	// 这里直接调用了枚举类型对象的相关方法(不需要写resource属性哦)
	// 这个在工作中用的非常频繁哦，也非常的有实际作用，要不然就直接用反射的进行对象的赋值了
	// 以后VO的转换就这样写哦，如果更复杂的话，就可以直接在接口中写default方法，自己是手动实现
	// @Mapping(target = "userType", expression = "java(userDO.getUserType().name())")
	// @Mapping(target = "userTypeName", expression = "java(userDO.getUserType().getValueName())")
	// List<UserVO> userDOList2UserVOList(List<UserDO> userDO);
	// 这种带 Java 表达式的好像无法做列表的转换，还是手动的进行一次for循环操作吧
}
