package com.keqi.springbootmvcjackson.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * `@JsonDeserialize(using = BigDecimalDeSerialize.class)`
 */
public class BigDecimalDeSerialize extends JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// 通过此方法可以获取到请求参数值
		String text = p.getText();

		JsonParser parser = ctxt.getParser();

		return new BigDecimal(text);
	}
}
