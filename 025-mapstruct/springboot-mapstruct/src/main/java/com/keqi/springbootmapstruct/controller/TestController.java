package com.keqi.springbootmapstruct.controller;

import com.keqi.springbootmapstruct.domain.*;
import com.keqi.springbootmapstruct.mapstruct.MapStructMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("test1")
	public Object test1() {

		Order order = new Order();
		order.setId(12345L);
		order.setOrderSn("orderSn");
		order.setOrderType(0);
		order.setReceiverKeyword("keyword");
		order.setSourceType(1);
		order.setStatus(2);

		MapStructMapper mapper = Mappers.getMapper(MapStructMapper.class);
		OrderQueryParam orderQueryParam = mapper.entity2queryParam(order);

		System.out.println(orderQueryParam);

		return "success";
	}


	@GetMapping("test2")
	public Object test2() {

		Source source = new Source();
		source.setId("1");
		source.setNumSource(12);
		source.setTotalCount(100);

		Target target = MapStructMapper.INSTANCE.source2targetSingle(source);

		System.out.println(target);
		return "success";
	}

	@GetMapping("test3")
	public Object test3() {

		Source source = new Source();
		source.setId("1");
		source.setNumSource(12);
		source.setTotalCount(100);

		Target target = MapStructMapper.INSTANCE.source2targetMutil(source);

		System.out.println(target);
		return "success";
	}

	@GetMapping("test4")
	public Object test4() {

		Person person = new Person();
		person.setFirstName("first");
		person.setDescription("perSonDescription");
		person.setHeight(183);
		person.setLastName("homejim");

		Address address = new Address();
		address.setDescription("addressDescription");
		address.setHouseNo(29);
		address.setStreet("street");
		address.setZipCode(344);

		DeliveryAddress deliveryAddress = MapStructMapper.INSTANCE.personAndAddressToDeliveryAddressDto(person, address);
		System.out.println(deliveryAddress);

		return "success";
	}

	@GetMapping("test5")
	public Object test5() {

		Address address = new Address();
		address.setDescription("addressDescription");
		address.setHouseNo(29);
		address.setStreet("street");
		address.setZipCode(344);

		DeliveryAddress deliveryAddress = new DeliveryAddress();
		MapStructMapper.INSTANCE.updateDeliveryAddressFromAddress(address, deliveryAddress);


		System.out.println(deliveryAddress);
		return "success";
	}

	@GetMapping("test6")
	public Object test6() {

		Source source = new Source();
		source.setId("1");
		source.setNumSource(12);
		source.setTotalCount(100);

		Target target = MapStructMapper.manualSourceToTarget(source);

		System.out.println(target);
		return "success";
	}

	@GetMapping("test7")
	public Object test7() {

		UserDO userDO = new UserDO();
		userDO.setUsername("admin");
		userDO.setUserType(UserType.SUPER_ADMIN);

		UserVO userVO = MapStructMapper.INSTANCE.userDO2UserVO(userDO);

		System.out.println(userVO);

		return "success";
	}
}
