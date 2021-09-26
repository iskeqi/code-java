package com.keqi.seed.core.validator;

import com.keqi.seed.core.pojo.BaseEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class EnumValidateValidator implements ConstraintValidator<EnumValidate, String> {

    private Class<?> clazz;

    @Override
    public void initialize(EnumValidate constraintAnnotation) {
        clazz = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (Object constant : clazz.getEnumConstants()) {
            BaseEnum baseEnum = (BaseEnum) constant;
            if (Objects.equals(value, baseEnum.getCode())) {
                return true;
            }
        }

        return false;
    }
}
