package com.superme.demo.utils;

import lombok.Data;

/**
 * description:<分页插件>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/26 20:44
 */
@Data
public class PageItem {

    private int pageNum = 1;

    private int pageSize = 200;

    private long pageStart = this.pageSize * (this.pageNum - 1);

    public void setPageNum(int pageNum) {
        if (pageNum <= 0) {
            pageNum = 1;
        }
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            pageSize = 200;
        }
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageItem(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
