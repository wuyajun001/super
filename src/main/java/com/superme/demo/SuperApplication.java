package com.superme.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * description:<SpringBoot启动入口>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/25 11:50
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
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
        return "<h1>Welcome To My SpringBoot !</h1>";
    }

}
