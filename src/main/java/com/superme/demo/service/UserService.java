package com.superme.demo.service;

import com.superme.demo.bean.User;
import com.superme.demo.utils.PageItem;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * description:<会员操作业务层接口>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/25 11:50
 */
public interface UserService {
    /**
     * Description:查询所有会员信息
     */
    List<User> getUsers();

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
