package com.titan.excel.context;

import cn.idev.excel.ExcelWriter;
import cn.idev.excel.read.metadata.ReadSheet;
import cn.idev.excel.write.metadata.WriteSheet;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Future;

/**
 * Excel导入上下文
 *
 * @author zy
 * @date 2025-07-22 16:51
 **/
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class ExcelImportContext extends TtExcelContext {

    private static final int MAX_ROWS_LIMIT = 1000;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 工作表名称
     */
    private String sheetName;

    /**
     * 错误头部类
     */
    private Class<?> errorHeadClass;

    /**
     * Excel写入器
     */
    private ExcelWriter excelWriter;

    /**
     * 写入工作表
     */
    private WriteSheet writeSheet;

    /**
     * 读取工作表
     */
    private ReadSheet readSheet;

    /**
     * 输出流
     */
    private OutputStream outputStream;

    /**
     * 输入流
     */
    private InputStream inputStream;

    /**
     * 异步任务
     */
    private Future<String> future;

    /**
     * 错误文件路径
     */
    private String errorFile;

    /**
     * 错误消息
     */
    private String failMsg;

    /**
     * 最大行数限制
     */
    private boolean validMaxRows;

    /**
     * 最大行数限制
     */
    private int maxRows = MAX_ROWS_LIMIT;

    /**
     * 是否验证表头
     */
    private boolean validHead = true;
}
