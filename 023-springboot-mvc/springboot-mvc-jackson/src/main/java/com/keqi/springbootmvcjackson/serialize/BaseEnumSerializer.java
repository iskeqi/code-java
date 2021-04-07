package com.keqi.springbootmvcjackson.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.keqi.springbootmvcjackson.enums.BaseEnum;

import java.io.IOException;
import java.util.Objects;

public class BaseEnumSerializer<T extends BaseEnum> extends JsonSerializer<T> {

	@Override
	public void serialize(T value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if (Objects.isNull(value)) {
			gen.writeNull();
		} else {
			gen.writeNumber(value.getCode());
		}
	}
}
