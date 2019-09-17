package com.superme.service.impl;


import com.alibaba.fastjson.JSON;
import com.superme.bean.User;
import com.superme.mapper.UserMapper;
import com.superme.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * description:<会员操作业务层实现>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/25 11:50
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {

        logger.info(JSON.toJSONString(userMapper.getUsers()));

        return userMapper.getUsers();
    }


}
