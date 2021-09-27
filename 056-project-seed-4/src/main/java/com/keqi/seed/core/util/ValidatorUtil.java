package com.keqi.seed.core.util;

import com.keqi.seed.core.exception.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.StringJoiner;

/**
 * 基于 javax.validation.Validator 封装的校验工具类
 *
 * @author keqi
 */
@Component
public class ValidatorUtil {

    private static Validator validator;

    @Autowired
    public void setValidator(Validator validator) {
        ValidatorUtil.validator = validator;
    }

    /**
     * 校验指定对象（支持嵌套子对象的校验）
     *
     * @param object object
     * @return 满足约束条件返回 true，不满足则返回 false
     */
    public static boolean checkValidate(Object object) {
        return CollectionUtils.isEmpty(validator.validate(object));
    }

    /**
     * 校验指定对象（支持嵌套子对象的校验）
     *
     * @param object object
     * @throws ValidatorException 如果不满足条件会抛出异常
     */
    public static void validate(Object object) throws ValidatorException {
        if (object == null) {
            throw new ValidatorException("param is null");
        }
        Set<ConstraintViolation<Object>> set = validator.validate(object);
        if (set != null && set.size() > 0) {
            StringJoiner stringJoiner = new StringJoiner(",");
            for (ConstraintViolation<Object> constraintViolation : set) {
                stringJoiner.add(constraintViolation.getMessage());
            }
            throw new ValidatorException(stringJoiner.toString());
        }
    }
}
