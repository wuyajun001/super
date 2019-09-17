package com.superme.service;

import com.superme.utils.PageItem;

import javax.servlet.http.HttpServletResponse;

/**
 * description:<POI业务层>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/9/3 9:35
 */
public interface PoiService {

    /**
     * 创建需要的数据
     */
    void creatPoiUser();

    /**
     * 输出表格
     */
    void getExcell(PageItem pageItem, HttpServletResponse response);

    /**
     * 使用阿里巴巴EasyExcel导出表格
     */
    void getEasyExcell(PageItem pageItem, HttpServletResponse response);

}
