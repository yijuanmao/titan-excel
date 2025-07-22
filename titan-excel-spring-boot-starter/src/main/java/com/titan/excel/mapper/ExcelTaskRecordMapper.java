package com.titan.excel.mapper;

import com.titan.excel.entity.ExcelTaskRecord;

import java.util.List;

/**
 * Excel导出任务Mapper接口
 *
 * @author zy
 * @date 2025-07-22 11:10
 **/
public interface ExcelTaskRecordMapper {

    /**
     * 创建Excel导出任务
     *
     * @param task Excel导出任务对象
     * @return 影响的行数
     */
    int insertExcelTaskRecord(ExcelTaskRecord task);

    /**
     * 更新Excel导出任务状态
     *
     * @param task Excel导出任务对象
     * @return 影响的行数
     */
    int updateExcelTaskRecord(ExcelTaskRecord task);

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
    List<ExcelTaskRecord> selectExcelTaskRecordList(ExcelTaskRecord exportTask);

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
