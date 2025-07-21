package com.titan.excel.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.URLUtil;
import cn.idev.excel.FastExcelFactory;
import cn.idev.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.titan.core.exception.TiTanExcelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Excel工具类
 *
 * @author zy
 * @date 2025-07-18 16:14
 **/
public class ExcelUtils {

    private static final Logger log = LoggerFactory.getLogger(ExcelUtils.class);

    private ExcelUtils() {
    }

    /**
     * 导出
     *
     * @param list     导出数据集合
     * @param fileName 文件名
     * @param clazz    导出数据类型
     * @param response 响应对象
     */
    public static <T> void export(List<T> list, String fileName, Class<T> clazz, HttpServletResponse response) {
        export(list, fileName, "Sheet1", Collections.emptySet(), clazz, response);
    }

    /**
     * 导出
     *
     * @param list                    导出数据集合
     * @param fileName                文件名
     * @param sheetName               工作表名称
     * @param excludeColumnFieldNames 排除字段
     * @param clazz                   导出数据类型
     * @param response                响应对象
     */
    public static <T> void export(List<T> list, String fileName, String sheetName, Set<String> excludeColumnFieldNames, Class<T> clazz, HttpServletResponse response) {
        String exportFileName = buildExportFileName(fileName);
        try (OutputStream out = response.getOutputStream()) {
            // 设置响应头
            setResponseHeaders(response, exportFileName);

            FastExcelFactory.write(out, clazz)
                    .autoCloseStream(false)
                    // 自动适配宽度
                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                    // 自动转换大数值
//                    .registerConverter(new ExcelBigNumberConverter())
                    .sheet(sheetName)
                    .excludeColumnFieldNames(excludeColumnFieldNames)
                    .doWrite(list);
        } catch (Exception e) {
            log.error("Excel导出异常: {}, 文件名: {}", e.getMessage(), fileName, e);
            response.reset();
            throw new TiTanExcelException("Excel导出异常: " + e.getMessage(), e);
        }
    }

    /**
     * 构建导出文件名
     *
     * @param fileName 文件名
     * @return 导出文件名
     */
    private static String buildExportFileName(String fileName) {
        return URLUtil.encode(String.format("%s_%s.xlsx", fileName, DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN)));
    }

    /**
     * 设置响应头
     *
     * @param response       响应对象
     * @param exportFileName 导出文件名
     */
    private static void setResponseHeaders(HttpServletResponse response, String exportFileName) {
        response.setHeader("Content-disposition", "attachment;filename=" + exportFileName);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
    }
}
