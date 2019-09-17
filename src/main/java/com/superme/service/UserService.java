package com.superme.service;

import com.superme.bean.User;

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



}
