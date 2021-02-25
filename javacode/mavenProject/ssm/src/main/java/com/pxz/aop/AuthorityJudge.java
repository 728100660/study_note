package com.pxz.aop;


import com.mchange.v1.util.ArrayUtils;
import com.pxz.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Aspect //标注这个类是一个切面
public class AuthorityJudge {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

//    @Before("execution(* com.pxz.controller.*.*(..))")  //切入点
//    public void before(){
////        行为
//        System.out.println("方法执行前");
//    }
//
//    @After("execution(* com.pxz.controller.*.*(..))")  //切入点
//    public void after(){
////        行为
//        System.out.println("方法执行后");
//    }
//
//    在环绕增强中，我们可以给定一个参数，代表我们要处理的切入点（要处理的方法）
    @Around("execution(* com.pxz.controller.*.*(..))")
    public String arround(ProceedingJoinPoint jp) throws Throwable {


        UserService userService;

        System.out.println("环绕前");
//        执行环绕前
        String proceed = (String) jp.proceed();

//        Object[] args = jp.getArgs();
//
//        MethodSignature methodSignature = (MethodSignature)jp.getSignature();
//
//        String[] parameterNames = methodSignature.getParameterNames();
//
//        System.out.println(parameterNames);
//
//        //获取参数名
//        int deviceIdIndex = ArrayUtils.indexOf(parameterNames, "userId");
//
//        Integer userId = null;
//
//        //通过参数 Index 过去参数信息
//        if (deviceIdIndex!=-1){
//            userId = (Integer)args[deviceIdIndex];
//        }
//
//        this.userService.getRole(userId);


//        System.out.println("articleId"+"为"+deviceId);
//
//        System.out.println(jp.getArgs());
//
//        System.out.println("环绕后");

        return proceed;
    }
}
