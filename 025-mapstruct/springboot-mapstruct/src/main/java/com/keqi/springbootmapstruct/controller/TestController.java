package com.keqi.springbootmapstruct.controller;

import com.keqi.springbootmapstruct.domain.Order;
import com.keqi.springbootmapstruct.domain.OrderQueryParam;
import com.keqi.springbootmapstruct.domain.Source;
import com.keqi.springbootmapstruct.domain.Target;
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
}
