package com.pxz.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class Log implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了"+o1.getClass().getName()+"的"+method.getName()+"方法，返回了"+o+"参数是");
        for(Object obj : objects){
            System.out.println(obj);
        }
    }
}
