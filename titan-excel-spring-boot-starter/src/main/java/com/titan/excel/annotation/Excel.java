package com.titan.excel.annotation;

import com.titan.core.enums.IBaseEnum;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义导出Excel数据注解
 *
 * @author zy
 * @date 2025-07-18 15:06
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {

    /**
     * 导出时在excel中排序
     */
    int index() default Integer.MAX_VALUE;

    /**
     * 导出到Excel中的名字.
     */
    String name() default "";

    /**
     * 日期格式, 如: yyyy-MM-dd
     */
    String dateFormat() default "";

    /**
     * 读取内容转表达式，如：(0=测试,1=生产)
     */
    String readConverter() default "";

    /**
     * 翻译枚举类
     */
    Class<?> converterEnum() default IBaseEnum.class;

    /**
     * 导出时在excel中每个列的高度 单位为字符
     */
    double height() default 14;

    /**
     * 导出时在excel中每个列的宽 单位为字符
     */
    double width() default 16;

    /**
     * BigDecimal 精度 默认:-1(默认不开启BigDecimal格式化)
     */
    int scale() default -1;

    /**
     * 导出列头背景色
     */
    IndexedColors headerBackgroundColor() default IndexedColors.GREY_50_PERCENT;

    /**
     * 导出列头字体颜色
     */
    IndexedColors headerColor() default IndexedColors.WHITE;

    /**
     * 导出单元格背景色
     */
    IndexedColors backgroundColor() default IndexedColors.WHITE;

    /**
     * 导出单元格字体颜色
     */
    IndexedColors color() default IndexedColors.BLACK;

    /**
     * 导出字段对齐方式
     */
    HorizontalAlignment align() default HorizontalAlignment.CENTER;

}
