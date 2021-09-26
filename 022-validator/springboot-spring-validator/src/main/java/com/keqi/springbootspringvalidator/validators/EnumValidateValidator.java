package com.keqi.springbootspringvalidator.validators;

import com.keqi.springbootspringvalidator.domain.BaseEnum;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

@Slf4j
public class EnumValidateValidator implements ConstraintValidator<EnumValidate, String> {

    private Class<?> clazz;

    @Override
    public void initialize(EnumValidate constraintAnnotation) {
        // 获取到注解中 value 属性指定的值
        // 本方法只会被调用一次（如果 value 中指定的值不一样，则每个不同的 value 值都会被调用一次）
        clazz = constraintAnnotation.value();
        // log.info("EnumConstantValidator.initialize() -> {}", clazz.toString());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 此方法是允许被并发访问的，所以必须要考虑线程安全问题（都是读操作，考虑啥并发问题）

        for (Object constant : clazz.getEnumConstants()) {
            BaseEnum baseEnum = (BaseEnum) constant;
            if (Objects.equals(value, baseEnum.getCode())) {
                return true;
            }
        }

        return false;
    }
}
