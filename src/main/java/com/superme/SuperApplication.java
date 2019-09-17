package com.superme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * description:<SpringBoot启动入口>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/25 11:50
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Controller
public class SuperApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(SuperApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SuperApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String welcome(){
        return "redirect:/index.html";
    }

}
