package com.titan.excel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Excel导入、导出任务记录
 *
 * @author zy
 * @date 2025-07-22 11:10
 **/
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExcelTaskRecord implements Serializable {

    private static final long serialVersionUID = 404281450091440115L;

    /**
     * 主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 类型：0-导入,1-导出,参照枚举类:{@link com.titan.core.enums.ExportType}
     */
    private Integer exportType;

    /**
     * 到处状态：参照枚举类:{@link com.titan.core.enums.ExportStatus}
     */
    private Integer exportStatus;

    /**
     * 源文件
     */
    private String sourceFile;

    /**
     * 预估记录数 可能包含空行数据不准确，但是大部分情况时准确的
     */
    private Long estimateCount;

    /**
     * 实际总记录数 为成功记录数+失败记录数
     */
    private Long totalCount;

    /**
     * 成功记录数
     */
    private Long successCount;

    /**
     * 失败记录数
     */
    private Long failCount;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 成功文件路径
     */
    private String successFileUrl;

    /**
     * 失败文件路径
     */
    private String failFileUrl;

    /**
     * 失败消息
     */
    private String failMsg;

    /**
     * 导入开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 导入结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    /**
     * 业务模块code,如：user、order,用户区分业务模块
     */
    private String businessCode;
}
