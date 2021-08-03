package com.keqi.seed.core.util;

import com.keqi.seed.core.exception.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.StringJoiner;

/**
 * 基于 javax.validation.Validator 封装的校验工具类
 *
 * @author keqi
 */
@Component
public class ValidatorUtil {

	private static Validator validator;

	@Autowired
	public void setValidator(Validator validator) {
		ValidatorUtil.validator = validator;
	}

	/**
	 * 校验指定对象（支持嵌套子对象的校验）
	 *
	 * @param object object
	 * @param <T>    r
	 */
	public static <T> boolean validate(T object) {
		Set<ConstraintViolation<T>> constraintViolationSet = validator.validate(object);
		if (!CollectionUtils.isEmpty(constraintViolationSet)) {
			StringJoiner stringJoiner = new StringJoiner(",");
			for (ConstraintViolation<T> constraintViolation : constraintViolationSet) {
				stringJoiner.add(constraintViolation.getMessage());
			}
			throw new ValidatorException(stringJoiner.toString());
		}
		return true;
	}
}
