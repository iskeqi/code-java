package com.keqi.springbootspringvalidator.util;

import com.keqi.springbootspringvalidator.domain.SysUserCreateRequestParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Collections;
import java.util.Set;

/**
 * 基于javax.validation.Validator封装的校验工具类
 */
@Component
@AllArgsConstructor
public class SpringValidatorUtil {

	private final Validator validator;

	/**
	 * 校验指定对象
	 *
	 * @param object object
	 * @param groups groups
	 * @param <T>    r
	 */
	public <T> boolean validate(T object, Class<?>... groups) {
		Set<ConstraintViolation<T>> constraintViolationSet = validator.validate(object);
		if (constraintViolationSet != null) {
			StringBuilder stringBuilder = new StringBuilder();
			for (ConstraintViolation<T> constraintViolation : constraintViolationSet) {
				String message = constraintViolation.getMessage();
				stringBuilder.append(message).append(",");
			}
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			throw new RuntimeException(stringBuilder.toString());
		}
		return true;
	}
}
