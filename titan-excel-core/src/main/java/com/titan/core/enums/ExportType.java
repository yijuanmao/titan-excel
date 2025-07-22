package com.titan.core.enums;

import lombok.Getter;

/**
 * 导出类型枚举
 *
 * @author zy
 * @date 2025-07-22 14:14
 **/
@Getter
public enum ExportType implements IBaseEnum<Integer> {

    /**
     * 导入
     */
    IMPORT(0, "导入"),

    /**
     * 导出
     */
    EXPORT(1, "导出"),

    ;

    private final Integer value;

    private final String name;

    ExportType(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
