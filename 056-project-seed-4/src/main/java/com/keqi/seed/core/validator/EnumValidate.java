package com.keqi.seed.core.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 枚举验证注解
 * <p>
 * 用法：@EnumValidate(message = "参数错误", value = GenderEnum.class)
 *
 * @author keqi
 */
@Documented
@Constraint(validatedBy = {EnumValidateValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface EnumValidate {

    String message() default "param is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> value();

}
