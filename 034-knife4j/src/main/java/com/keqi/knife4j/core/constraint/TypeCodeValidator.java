package com.keqi.knife4j.core.constraint;

import com.keqi.knife4j.sys.util.DictUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 配合 DictUtil 工具类校验 typeCode 对应的 itemCode 是否合法
 *
 * @author keqi
 */
public class TypeCodeValidator implements ConstraintValidator<TypeCode, String> {

	private String typeCode;

	/**
	 * 初始化方法，一般用来设置注解中指定的值
	 *
	 * @param typeCode typeCode
	 */
	@Override
	public void initialize(TypeCode typeCode) {
		// 获取注解上方的 value 属性值
		this.typeCode = typeCode.value();
	}

	/**
	 * 具体验证逻辑的方法
	 *
	 * @param itemCode itemCode
	 * @param context  context
	 * @return r
	 */
	@Override
	public boolean isValid(String itemCode, ConstraintValidatorContext context) {
		// 如果通过 typeCode 和 itemCode 没有查询到对应的 itemValue ，则证明此 itemCode 为非法参数
		return DictUtil.getItemName(typeCode, itemCode) != null;
	}
}
