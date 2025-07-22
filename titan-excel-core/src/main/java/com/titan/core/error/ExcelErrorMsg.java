package com.titan.core.error;

import lombok.Data;
import lombok.ToString;

/**
 * Excel错误信息类
 */
@Data
@ToString
public class ExcelErrorMsg {

    /**
     * 行号
     */
    private Integer row;

    /**
     * 错误信息
     */
    private String msg;

    public ExcelErrorMsg(Integer row, String msg) {
        this.row = row;
        this.msg = msg;
    }

}
