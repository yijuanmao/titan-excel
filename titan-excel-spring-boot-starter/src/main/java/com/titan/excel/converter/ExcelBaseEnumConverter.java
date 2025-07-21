package com.titan.excel.converter;

import cn.idev.excel.converters.Converter;
import cn.idev.excel.enums.CellDataTypeEnum;
import cn.idev.excel.metadata.GlobalConfiguration;
import cn.idev.excel.metadata.data.ReadCellData;
import cn.idev.excel.metadata.data.WriteCellData;
import cn.idev.excel.metadata.property.ExcelContentProperty;
import com.titan.core.enums.IBaseEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * Excel基础枚举转换器
 *
 * @author zy
 * @date 2025-07-21 15:41
 **/
@SuppressWarnings("unused")
public class ExcelBaseEnumConverter implements Converter<IBaseEnum<?>> {

    @Override
    public Class<IBaseEnum> supportJavaTypeKey() {
        return IBaseEnum.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 转换为 Java 数据（读取 Excel）
     */
    @Override
    public IBaseEnum<?> convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        return IBaseEnum.getBaseEnumByName(cellData.getStringValue(), contentProperty.getField().getType());
    }

    /**
     * 转换为 Excel 数据（写入 Excel）
     */
    @Override
    public WriteCellData<String> convertToExcelData(IBaseEnum<?> value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        if (value == null) {
            return new WriteCellData<>(StringUtils.EMPTY);
        }
        return new WriteCellData<>(value.getName());
    }
}
