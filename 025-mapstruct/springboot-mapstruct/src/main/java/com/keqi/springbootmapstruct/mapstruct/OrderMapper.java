package com.keqi.springbootmapstruct.mapstruct;

import com.keqi.springbootmapstruct.domain.Order;
import com.keqi.springbootmapstruct.domain.OrderQueryParam;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

	OrderQueryParam entity2queryParam(Order order);
}
