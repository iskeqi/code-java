package com.keqi.springbootmvcjackson.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 如果 BigDecimal 后面有很多个 0 ，那么可以通过如下方式在 VO 中的属性上使用注解指定序列化方式，以去除后缀中的0
 * <p>
 * 此种方案可以适用于任何数据类型，只要编写对应的序列化类即可
 * <p>
 * `@JsonSerializer(using = BigDecimalSerialize.class)`
 */
public class BigDecimalSerialize extends JsonSerializer<BigDecimal> {

	@Override
	public void serialize(BigDecimal bigDecimal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		if (Objects.nonNull(bigDecimal)) {
			// 不为空时直接去掉后缀中的 0
			jsonGenerator.writeNumber(bigDecimal.stripTrailingZeros());
		} else {
			jsonGenerator.writeNull();
		}
	}
}
