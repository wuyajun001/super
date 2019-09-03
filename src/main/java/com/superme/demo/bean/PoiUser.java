package com.superme.demo.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

/**
 * description:<POI报表测试对象>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/26 19:12
 */
@Data
public class PoiUser extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = 6499743074132884743L;

    @ExcelProperty(index = 0, value = "用户Id")
    private long userId;
    @ExcelProperty(index = 1, value = "用户名称")
    private String userName;
    @ExcelProperty(index = 2, value = "备注1")
    private String line1;
    @ExcelProperty(index = 3, value = "备注2")
    private String line2;
    @ExcelProperty(index = 4, value = "备注3")
    private String line3;
    @ExcelProperty(index = 5, value = "备注4")
    private String line4;
    @ExcelProperty(index = 6, value = "备注5")
    private String line5;
    @ExcelProperty(index = 7, value = "备注6")
    private String line6;
    @ExcelProperty(index = 8, value = "备注7")
    private String line7;
    @ExcelProperty(index = 9, value = "备注8")
    private String line8;
}
