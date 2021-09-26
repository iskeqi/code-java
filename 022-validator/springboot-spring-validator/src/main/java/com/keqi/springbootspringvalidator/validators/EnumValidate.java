package com.keqi.springbootspringvalidator.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义枚举常量
 */
@Documented
@Constraint(validatedBy = {EnumValidateValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface EnumValidate {

	String message() default "{constraint.default.const.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	Class<?> value();

}
