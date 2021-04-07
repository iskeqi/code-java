package com.keqi.seed.core.web.converter;

import com.keqi.seed.core.pojo.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.NumberUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * String -> BaseEnum 类型转换器
 *
 * @author keqi
 */
public final class MyStringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

	@Override
	public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
		return new StringToBaseEnum<>(targetType);
	}

	private static final class StringToBaseEnum<T extends BaseEnum> implements Converter<String, T> {

		private final Map<String, T> enumMap = new HashMap<>();

		public StringToBaseEnum(Class<T> targetType) {
			T[] enumConstants = targetType.getEnumConstants();
			for (T e : enumConstants) {
				enumMap.put(e.getCode() + "", e);
			}
		}

		@Override
		@Nullable
		public T convert(String source) {
			if (source.isEmpty() || "\"\"".equals(source)) {
				return null;
			}
			return enumMap.get(source);
		}
	}
}
