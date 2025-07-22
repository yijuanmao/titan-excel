package com.titan.excel.process;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import com.titan.core.error.ExcelErrorMsg;
import com.titan.excel.context.ExcelImportContext;
import com.titan.excel.entity.ExcelTaskRecord;
import com.titan.excel.param.ExcelImportParam;

import java.util.Collection;
import java.util.List;

/**
 * Excel导入操作步骤处理接口
 *
 * @author zy
 * @date 2025-07-22 11:10
 **/
public interface ExcelImportStepProcess {

    /**
     * 创建Excel导入任务
     *
     * @param param 请求参数
     * @return ExcelExportTask
     */
    ExcelTaskRecord createTask(ExcelImportParam param);

    /**
     * 导入前操作
     *
     * @param task 任务
     */
    void beforeImport(ExcelTaskRecord task);

    /**
     * 开始执行导入
     *
     * @param context 导入上下文
     */
    void onImport(ExcelImportContext context);

    /**
     * 开始执行写入
     *
     * @param dataList     导入数据列表
     * @param context      导入上下文
     * @param errorMsgList 错误信息列表
     */
    void onWrite(Collection<?> dataList, ExcelImportContext context, List<ExcelErrorMsg> errorMsgList);

    /**
     * 失败处理
     *
     * @param context 导入上下文
     */
    void onError(ExcelImportContext context);

    /**
     * 完成后操作
     *
     * @param context 导入上下文
     */
    void onComplete(ExcelImportContext context);

}
