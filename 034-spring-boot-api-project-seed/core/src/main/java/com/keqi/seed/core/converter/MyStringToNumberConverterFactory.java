package com.keqi.seed.core.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.NumberUtils;

/**
 * String -> Number 类型转换器
 * <p>
 * 此处替换掉了默认配置的 org.springframework.core.convert.support.StringToNumberConverterFactory 类型转换工厂
 *
 * @author keqi
 */
public final class MyStringToNumberConverterFactory implements ConverterFactory<String, Number> {

    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        @Nullable
        public T convert(String source) {
            if (source.isEmpty() || "\"\"".equals(source)) {
                return null;
            }
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }
}
