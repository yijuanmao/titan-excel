package com.titan.excel.service;

import com.titan.excel.entity.ExcelTaskRecord;

import java.util.List;

/**
 * Excel导出任务服务接口
 *
 * @author zy
 * @date 2025-07-22 15:01
 **/
public interface IExcelTaskRecordService {

    /**
     * 创建Excel导出任务
     *
     * @param task Excel导出任务对象
     * @return 是否成功
     */
    boolean insertExcelExportTask(ExcelTaskRecord task);

    /**
     * 更新Excel导出任务状态
     *
     * @param task Excel导出任务对象
     * @return 是否成功
     */
    boolean updateExcelExportTask(ExcelTaskRecord task);

    /**
     * 根据ID查询Excel导出任务
     *
     * @param id 任务ID
     * @return Excel导出任务对象
     */
    ExcelTaskRecord selectTaskById(Long id);

    /**
     * 根据条件Excel导出任务
     *
     * @param exportTask 到处用户对象
     * @return Excel导出任务列表
     */
    List<ExcelTaskRecord> selectExcelExportTaskList(ExcelTaskRecord exportTask);

    /**
     * 删除Excel导出任务
     *
     * @param id 任务ID
     * @return 影响的行数
     */
    int deleteTaskById(Long id);

    /**
     * 批量删除Excel导出任务
     *
     * @param ids 任务ID列表
     * @return 影响的行数
     */
    int deleteTaskByIds(List<Long> ids);
}
