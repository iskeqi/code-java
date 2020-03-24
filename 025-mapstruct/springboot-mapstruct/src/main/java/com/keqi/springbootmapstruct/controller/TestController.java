package com.keqi.springbootmapstruct.controller;

import com.keqi.springbootmapstruct.domain.Order;
import com.keqi.springbootmapstruct.domain.OrderQueryParam;
import com.keqi.springbootmapstruct.mapstruct.OrderMapper;
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

		OrderMapper mapper = Mappers.getMapper(OrderMapper.class);
		OrderQueryParam orderQueryParam = mapper.entity2queryParam(order);

		System.out.println(orderQueryParam);

		return "success";
	}
}
