package com.titan.excel.service.impl;

import com.titan.excel.entity.ExcelTaskRecord;
import com.titan.excel.mapper.ExcelTaskRecordMapper;
import com.titan.excel.service.IExcelTaskRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Excel导出任务Service实现类
 *
 * @author zy
 * @date 2025-07-22 15:02
 **/
@Service
@RequiredArgsConstructor
public class ExcelTaskRecordServiceImpl implements IExcelTaskRecordService {

    private final ExcelTaskRecordMapper excelTaskRecordMapper;

    /**
     * 创建Excel导出任务
     *
     * @param task Excel导出任务对象
     * @return 是否成功
     */
    @Override
    public boolean insertExcelExportTask(ExcelTaskRecord task) {
        LocalDateTime now = LocalDateTime.now();
        task.setCreateTime(now);
        task.setUpdateTime(now);
        return excelTaskRecordMapper.insertExcelTaskRecord(task) > 0;
    }

    /**
     * 更新Excel导出任务状态
     *
     * @param task Excel导出任务对象
     * @return 是否成功
     */
    @Override
    public boolean updateExcelExportTask(ExcelTaskRecord task) {
        task.setUpdateTime(LocalDateTime.now());
        return excelTaskRecordMapper.updateExcelTaskRecord(task) > 0;
    }

    /**
     * 根据ID查询Excel导出任务
     *
     * @param id 任务ID
     * @return Excel导出任务对象
     */
    @Override
    public ExcelTaskRecord selectTaskById(Long id) {
        return excelTaskRecordMapper.selectTaskById(id);
    }

    /**
     * 根据条件Excel导出任务
     *
     * @param exportTask 到处用户对象
     * @return Excel导出任务列表
     */
    @Override
    public List<ExcelTaskRecord> selectExcelExportTaskList(ExcelTaskRecord exportTask) {
        return excelTaskRecordMapper.selectExcelTaskRecordList(exportTask);
    }

    /**
     * 删除Excel导出任务
     *
     * @param id 任务ID
     * @return 影响的行数
     */
    @Override
    public int deleteTaskById(Long id) {
        return excelTaskRecordMapper.deleteTaskById(id);
    }

    /**
     * 批量删除Excel导出任务
     *
     * @param ids 任务ID列表
     * @return 影响的行数
     */
    @Override
    public int deleteTaskByIds(List<Long> ids) {
        return excelTaskRecordMapper.deleteTaskByIds(ids);
    }
}
