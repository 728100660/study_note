package com.pxz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class test {
    @RequestMapping("/t1")
    public String testAno(){
        System.out.println("我进来了");
        return "hello";
    }
}
