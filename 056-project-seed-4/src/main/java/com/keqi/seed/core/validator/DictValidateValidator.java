package com.keqi.seed.core.validator;

import cn.hutool.extra.spring.SpringUtil;
import com.keqi.seed.core.pojo.BaseDictValidate;
import com.keqi.seed.core.validator.annotation.DictValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DictValidateValidator implements ConstraintValidator<DictValidate, String> {

    private static final String BEAN_NAME = "dictItemService";

    private String typeCode;
    private BaseDictValidate validate;

    @Override
    public void initialize(DictValidate constraintAnnotation) {
        typeCode = constraintAnnotation.value();

        validate = SpringUtil.getBean(BEAN_NAME);
        if (validate == null) {
            throw new RuntimeException("名称为 " + BEAN_NAME + " 的 Bean 不存在");
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validate.existItemCode(typeCode, value);
    }
}
