package com.titan.excel.param;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Excel导入参数类
 *
 * @author zy
 * @date 2025-07-22 11:28
 **/
@Data
@ToString
public class BaseExcelParam implements Serializable {

    private static final long serialVersionUID = -1004931567933142575L;

    /**
     * 业务模块code
     */
    private String businessCode;

    public BaseExcelParam() {
    }

    public BaseExcelParam(String businessCode) {
        this.businessCode = businessCode;
    }
}
