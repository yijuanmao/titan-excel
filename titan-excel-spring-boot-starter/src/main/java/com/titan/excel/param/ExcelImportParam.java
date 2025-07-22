package com.titan.excel.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.InputStream;
import java.io.Serializable;

/**
 * Excel导入参数类
 *
 * @author zy
 * @date 2025-07-22 11:28
 **/
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class ExcelImportParam extends BaseExcelParam implements Serializable {

    private static final long serialVersionUID = 6427020594787962366L;

    /**
     * 操作人，可以是用户id，也可以使用用户名
     */
    private String operatorBy;

    /**
     * 输入流
     */
    private InputStream stream;

    /**
     * 文件名称
     */
    private String filename;

    /**
     * 导入对应的实体类
     */
    private Class<?> headClass;

    /**
     * 分批次大小，如果你导入1w条数据，每次1000会分10次读到内存中
     */
    private int batchSize = 1000;

    /**
     * 是否限制导入行数，默认false，如果限制行数将会出发行数限制异常，例如限制1000行，你的文件如果超过1000行将会抛异常
     */
    private boolean validMaxRows = false;

    /**
     * 行数限制validMaxRows=true时起作用
     */
    private int maxRows = 1000;

    /**
     * 是否进行表头校验，顺序单元格内容都应该与实体类保持一致。
     */
    private boolean validHead = true;

    public ExcelImportParam() {
    }

    public ExcelImportParam(InputStream stream, String filename, Class<?> headClass) {
        this.stream = stream;
        this.filename = filename;
        this.headClass = headClass;
    }
}
