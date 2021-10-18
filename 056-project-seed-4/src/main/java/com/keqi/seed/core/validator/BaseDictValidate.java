package com.keqi.seed.core.validator;

/**
 * 用于字典验证注解(全局只能有一个实现了此接口的类，且这个 Bean 对象名称为：dictItemService)
 *
 * @author keqi
 */
public interface BaseDictValidate {

    boolean existItemCode(String typeCode, String itemCode);
}
