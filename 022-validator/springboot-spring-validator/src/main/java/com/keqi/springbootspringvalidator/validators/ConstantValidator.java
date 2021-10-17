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
		// 获取设置的字段值，注解的 value 值（这个地方应该不能这么写，必须要考虑并发问题）
		// 本方法只有在第一次访问的时候才会被调用，而不是每次都调用
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
		// 此方法是被允许并发访问的，所以，必须要通过实现机制来考虑并发安全问题
		// 判断参数是否等于设置的字段值，返回结果
		return constant.equals(value);
	}
}
