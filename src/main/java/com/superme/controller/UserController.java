package com.superme.controller;

import com.superme.bean.User;
import com.superme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description:<会员操作控制层>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/25 11:50
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
