package com.keqi.springbootmvcjackson.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.keqi.springbootmvcjackson.enums.BaseEnum;

import java.io.IOException;
import java.util.Objects;

public class BaseEnumDeSerializer<T extends BaseEnum> extends JsonDeserializer<T> implements ContextualDeserializer {

	private JavaType type;

	public BaseEnumDeSerializer() {
	}

	public BaseEnumDeSerializer(JavaType type) {
		this.type = type;
	}

	@Override
	public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String text = p.getText();
		if (text != null) {
			Class<BaseEnum> clazz = (Class<BaseEnum>) type.getRawClass();
			BaseEnum[] enumConstants = clazz.getEnumConstants();
			for (BaseEnum e : enumConstants) {
				if (Objects.equals(e.getCode(), Integer.valueOf(text))) {
					return (T) e;
				}
			}
		}
		return null;
	}

	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
		JavaType type = ctxt.getContextualType() != null ? ctxt.getContextualType() : property.getMember().getType();
		return new BaseEnumDeSerializer<>(type);
	}
}
