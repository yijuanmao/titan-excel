package com.titan.core.enums;

/**
 * Excel列类型枚举
 *
 * @author zy
 * @date 2025-07-18 16:06
 **/
public enum ExcelColumnType {

    /**
     * 数字
     */
    NUMERIC(0),

    /**
     * 字符串
     */
    STRING(1),

    /**
     * 图片
     */
    IMAGE(2);

    private final int value;

    ExcelColumnType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
