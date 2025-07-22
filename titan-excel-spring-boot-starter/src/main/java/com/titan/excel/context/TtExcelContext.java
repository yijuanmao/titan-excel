package com.titan.excel.context;

import com.titan.excel.entity.ExcelTaskRecord;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Titan Excel上下文类
 *
 * @author zy
 * @date 2025-07-22 16:48
 **/
@Data
@ToString
public class TtExcelContext implements Serializable {

    private static final long serialVersionUID = -3982485461235819866L;

    /**
     * Excel导出任务
     */
    private ExcelTaskRecord task;

    /**
     * 导入总条数
     */
    private Long totalCount = 0L;

    /**
     * 导入失败条数
     */
    private Long failCount = 0L;

    /**
     * 导入成功条数
     */
    private Long successCount = 0L;
}
