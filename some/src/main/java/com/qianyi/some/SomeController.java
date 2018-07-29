package com.qianyi.some;

import com.qianyi.aop.MyAnnotation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //client端开启refresh机制 获取程序状态改变刷新
public class SomeController {

    @Value("${my.message}") //1
    private String message;

    @MyAnnotation(methdname = "getsome")
    @RequestMapping(value = "/getsome")
    @RefreshScope
    public String getsome(){
        System.out.println("---开始----");
        return message;
    }
}
