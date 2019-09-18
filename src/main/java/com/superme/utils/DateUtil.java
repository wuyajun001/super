package com.superme.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:<时间格式工具类>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/25 11:50
 */
public class DateUtil {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * 将日期转换为字符串
     *
     * @param date   DATE日期
     * @param format 转换格式
     * @return 字符串日期
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

}