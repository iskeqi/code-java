package com.keqi.enmutest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EnumUtil {

    public static <T> String getCodeName(Class<T> clazz, Integer code) {
        T[] enumConstants = clazz.getEnumConstants();
        Method getCode = null;
        Method getName = null;
        try {
            getCode = clazz.getMethod("getCode");
            getName = clazz.getMethod("getCodeName");
            for (T t : enumConstants) {
                Integer c = (Integer) getCode.invoke(t);
                if (code.equals(c)) {
                    return (String) getName.invoke(t);
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
