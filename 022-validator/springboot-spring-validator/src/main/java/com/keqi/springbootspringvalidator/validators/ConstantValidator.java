package com.keqi.springbootspringvalidator.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义注解 ' @Constant ' 对应的验证逻辑
 */
public class ConstantValidator implements ConstraintValidator<Constant, String> {

	private String constant;

	/**
	 * 初始化方法，一般用来设置注解中指定的值
	 *
	 * @param constraintAnnotation constraintAnnotation
	 */
	@Override
	public void initialize(Constant constraintAnnotation) {
		// 获取设置的字段值，注解的 value 值
		this.constant = constraintAnnotation.value();
	}

	/**
	 * 具体验证逻辑的方法
	 * @param value value
	 * @param context context
	 * @return r
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// 判断参数是否等于设置的字段值，返回结果
		return constant.equals(value);
	}
}
