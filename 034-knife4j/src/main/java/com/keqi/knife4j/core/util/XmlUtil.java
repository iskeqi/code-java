package com.keqi.knife4j.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * XML 工具类，使用 jackson-dataformat-xml 封装
 *
 * @author keqi
 */
public class XmlUtil {

    private static final ObjectMapper objectMapper;

    static {
        // 此对象线程安全
        objectMapper = new XmlMapper();
        // 反序列化时忽略未知字段，否则会抛出 UnrecognizedPropertyException 异常
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 格式化输出，便于阅读，一般情况下不要加上这行配置
        // objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * 同时支持对象/数组/Map，属性值为 null 时，该属性也会输出（如需忽略指定属性可以使用 @JsonIgnore 注解用于修饰具体属性）
     *
     * @param value value
     * @return r
     */
    public static String writeValueAsString(Object value) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 支持xml字符串转对象/Map，不支持数组（属性名不同会自动忽略）
     *
     * @param content   content
     * @param valueType valueType
     * @param <T>       t
     * @return r
     */
    public static <T> T readValue(String content, Class<T> valueType) {
        T t = null;
        try {
            t = objectMapper.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 支持 xml 字符串转数组/List<Map>（属性名不同会自动忽略）
     *
     * @param content      content
     * @param valueTypeRef valueTypeRef
     * @param <T>          t
     * @return r
     */
    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) {
        T t = null;
        try {
            t = objectMapper.readValue(content, valueTypeRef);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }
}
