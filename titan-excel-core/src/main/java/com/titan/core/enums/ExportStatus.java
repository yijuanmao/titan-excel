package com.titan.core.enums;

import lombok.Getter;

/**
 * 导出状态枚举
 *
 * @author zy
 * @date 2025-07-22 14:14
 **/
@Getter
public enum ExportStatus implements IBaseEnum<Integer> {

    /**
     * 初始化
     */
    INIT(0, "初始化"),

    /**
     * 进行中
     */
    ING(1, "进行中"),

    /**
     * 成功
     */
    SUCCESS(2, "成功"),

    /**
     * 失败
     */
    FAIL(3, "失败"),

    ;

    private final Integer value;

    private final String name;

    ExportStatus(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
