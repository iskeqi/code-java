package com.keqi.seed.core.validator.annotation;

import com.keqi.seed.core.validator.DictValidateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 字典验证注解
 * <p>
 * 用法：@DictValidate(message = "参数错误", value = "event_type")
 *
 * @author keqi
 */
@Documented
@Constraint(validatedBy = {DictValidateValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface DictValidate {

    String message() default "param is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();

}
