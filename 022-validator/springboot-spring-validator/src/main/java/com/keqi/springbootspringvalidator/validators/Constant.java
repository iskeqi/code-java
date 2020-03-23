package com.keqi.springbootspringvalidator.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义注解
 */
@Documented
@Constraint(validatedBy = {ConstantValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface Constant {

	String message() default "{constraint.default.const.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String value();

}
