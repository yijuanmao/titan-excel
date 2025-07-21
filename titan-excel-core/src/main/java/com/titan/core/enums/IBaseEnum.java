package com.titan.core.enums;

import java.io.Serializable;
import java.util.Objects;

/**
 * 基础枚举接口
 *
 * @author zy
 * @date 2025-07-21 15:38
 **/
public interface IBaseEnum<T extends Serializable> {

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    T getValue();

    /**
     * 获取枚举描述
     *
     * @return 枚举描述
     */
    String getName();

    /**
     * 根据value获取枚举类
     *
     * @param value 枚举值
     * @param clazz 枚举类
     * @return 枚举对象
     */
    static <E extends Enum<E> & IBaseEnum<T>, T extends Serializable> E getByValue(T value, Class<E> clazz) {
        if (value == null || clazz == null) {
            return null;
        }
        for (E e : clazz.getEnumConstants()) {
            if (Objects.equals(e.getValue(), value)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 根据枚举描述获取
     *
     * @param name  枚举描述
     * @param clazz 枚举类
     * @return 枚举对象
     */
    @SuppressWarnings("unused")
    static <E extends Enum<E> & IBaseEnum<?>> E getBaseEnumByName(String name, Class<?> clazz) {
        for (Object e : clazz.getEnumConstants()) {
            if (e instanceof IBaseEnum<?> && Objects.equals(((IBaseEnum<?>) e).getName(), name)) {
                return (E) e;
            }
        }
        return null;
    }
}
