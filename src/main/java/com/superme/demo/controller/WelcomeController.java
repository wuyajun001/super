package com.superme.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:<欢迎页面>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/9/6 12:45
 */
@RestController
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping(value = "/")
    public String welcome(){
        return "<h1>Welcome To My SpringBoot !</h1>";
    }

}
