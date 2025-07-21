package com.titan.core.enums;

import lombok.Getter;

/**
 * Excel列类型枚举
 *
 * @author zy
 * @date 2025-07-18 16:06
 **/
@Getter
public enum ExcelColumnType implements IBaseEnum<Integer> {

    /**
     * 数字
     */
    NUMERIC(0, "数字"),

    /**
     * 字符串
     */
    STRING(1, "字符串"),

    /**
     * 图片
     */
    IMAGE(2, "图片");

    private final Integer value;

    private final String name;

    ExcelColumnType(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
