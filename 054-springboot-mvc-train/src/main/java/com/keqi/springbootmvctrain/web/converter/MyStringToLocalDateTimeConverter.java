package com.keqi.springbootmvctrain.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * String -> LocalDateTime 类型转换器
 *
 * @author keqi
 */
public final class MyStringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(String source) {
        if (source.isEmpty() || "\"\"".equals(source)) {
            return null;
        }
        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
