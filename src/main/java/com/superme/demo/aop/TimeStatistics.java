package com.superme.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * description:<面向切面编程之----环绕>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/9/10 20:19
 */
@Aspect
@Component
public class TimeStatistics {

    @Pointcut("execution(* com.superme.demo.service.*.*(..))")
    public void pointCut() {
    }

    @Around("com.superme.demo.aop.TimeStatistics.pointCut()")
    public void around(ProceedingJoinPoint poj) {
        long start = System.currentTimeMillis();

        // 初始化目标对象
        Method method = null;
        try {
            // 获取节点
            poj.proceed();

            // 获取目标方法名
            Signature signature = poj.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            method = methodSignature.getMethod();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(method + "耗时:" + (end - start));
    }


}
