package com.titan.excel.process.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.titan.core.enums.ExportStatus;
import com.titan.core.enums.ExportType;
import com.titan.core.error.ExcelErrorMsg;
import com.titan.excel.context.ExcelImportContext;
import com.titan.excel.entity.ExcelTaskRecord;
import com.titan.excel.param.ExcelImportParam;
import com.titan.excel.process.ExcelImportStepProcess;
import com.titan.excel.service.IExcelTaskRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * 默认Excel导入处理类
 *
 * @author zy
 * @date 2025-07-22 16:59
 **/
@Slf4j
@RequiredArgsConstructor
public class DefaultExcelImportProcess implements ExcelImportStepProcess {

    private final IExcelTaskRecordService excelExportTaskService;

    /**
     * 创建Excel导入任务
     *
     * @param param 请求参数
     * @return ExcelExportTask
     */
    @Override
    public ExcelTaskRecord createTask(ExcelImportParam param) {
        ExcelTaskRecord task = new ExcelTaskRecord();
        task.setCreateBy(param.getOperatorBy());
        task.setUpdateBy(param.getOperatorBy());
        task.setExportType(ExportType.IMPORT.getValue());
        task.setExportStatus(ExportStatus.INIT.getValue());
        task.setEstimateCount(0L);
        task.setTotalCount(0L);
        task.setSuccessCount(0L);
        task.setFailCount(0L);
        task.setFileName(param.getFilename());
        task.setStartTime(LocalDateTime.now());
        task.setBusinessCode(param.getBusinessCode());
        excelExportTaskService.insertExcelExportTask(task);
        return task;
    }

    /**
     * 导入前操作
     *
     * @param task 任务
     */
    @Override
    public void beforeImport(ExcelTaskRecord task) {
        //留着业务扩展

    }

    /**
     * 开始执行导入
     *
     * @param context 导入上下文
     */
    @Override
    public void onImport(ExcelImportContext context) {
        ExcelTaskRecord task = context.getTask();
        task.setExportStatus(ExportStatus.ING.getValue());
        task.setFailCount(context.getFailCount());
        task.setSuccessCount(context.getSuccessCount());
        task.setTotalCount(context.getTotalCount());
        excelExportTaskService.updateExcelExportTask(task);
    }

    /**
     * 开始执行写入
     *
     * @param dataList     导入数据列表
     * @param context      导入上下文
     * @param errorMsgList 错误信息列表
     */
    @Override
    public void onWrite(Collection<?> dataList, ExcelImportContext context, List<ExcelErrorMsg> errorMsgList) {
        if (CollectionUtil.isEmpty(dataList)){
            log.debug("导入数据列表为空，跳过写入操作");
        }
        for (Object o : dataList) {

        }
    }

    /**
     * 失败处理
     *
     * @param context 导入上下文
     */
    @Override
    public void onError(ExcelImportContext context) {

    }

    /**
     * 完成后操作
     *
     * @param context 导入上下文
     */
    @Override
    public void onComplete(ExcelImportContext context) {

    }
}
