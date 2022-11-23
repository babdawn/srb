package com.atguigu.srb.core.pojo.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DictData {
    @ExcelProperty(value = "id")
    private String id;
    @ExcelProperty(value = "上级id")
    private String parentId;
    @ExcelProperty(value = "名称")
    private String name;
    @ExcelProperty(value = "值")
    private String value;
    @ExcelProperty(value = "编码")
    private String code;

}
