package com.superme.controller;

import com.superme.bean.User;
import com.superme.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping(value = "/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @RequestMapping(value = "/save")
    public String save(@RequestParam String key, @RequestParam String value, String outTime) {
        if (StringUtils.isBlank(key)) {
            return "error";
        }

        System.out.println(key + " " + value + " " + outTime);

        if (!StringUtils.isBlank(outTime)) {
            redisTemplate.opsForValue().set(key, value, Long.parseLong(outTime));
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
        return "success";
    }

    @RequestMapping(value = "/get")
    public String get(@RequestParam String key) {
        if (StringUtils.isBlank(key)) {
            return "error";
        }
        return (String) redisTemplate.opsForValue().get(key);

    }


}
