package com.keqi.springwebsocketagain.uitl;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * JSON 工具类，使用 jackson-bind 封装
 * <p>
 * // @JsonInclude(JsonInclude.Include.NON_NULL) // 此注解用在实体类上，如果实体类中的属性为 null 时，不会被序列化
 *
 * @author keqi
 */
@Slf4j
public class JsonUtil {

	private static final ObjectMapper objectMapper;

	static {
		objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	/**
	 * 同时支持对象/数组/Map，属性值为 null 时，该属性也会输出（如需忽略指定属性可以使用 @JsonIgnore 注解用于修饰具体属性）
	 *
	 * @param value value
	 * @return r
	 */
	public static String writeValueAsString(Object value) {
		String json = null;
		if (value != null) {
			try {
				json = objectMapper.writeValueAsString(value);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		return json;
	}

	/**
	 * 支持JSON字符串转对象/Map，不支持数组（属性名不同会自动忽略）
	 *
	 * @param content   content
	 * @param valueType valueType
	 * @param <T>       t
	 * @return r
	 */
	public static <T> T readValue(String content, Class<T> valueType) {
		T t = null;
		if (StrUtil.isNotBlank(content)) {
			try {
				t = objectMapper.readValue(content, valueType);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		return t;
	}

	/**
	 * 支持 JSON 字符串转数组/List<Map>（属性名不同会自动忽略）
	 *
	 * @param content      content
	 * @param valueTypeRef valueTypeRef
	 * @param <T>          t
	 * @return r
	 */
	public static <T> T readValue(String content, TypeReference<T> valueTypeRef) {
		T t = null;
		if (StrUtil.isNotBlank(content)) {
			try {
				t = objectMapper.readValue(content, valueTypeRef);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		return t;
	}

	/**
	 * 将对象序列化成 json 字符串并写入到指定的文件中
	 *
	 * @param resultFile
	 * @param value
	 */
	public static void writeValue(File resultFile, Object value) {
        try {
            objectMapper.writeValue(resultFile, value);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
