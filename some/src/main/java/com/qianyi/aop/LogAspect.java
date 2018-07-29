package com.qianyi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.qianyi.aop.MyAnnotation)")
    private void  addAdvice(){}

    @Around("addAdvice()")
    public Object AddLog(ProceedingJoinPoint pjp){
        System.out.println("-------start------");
        Object result=null;
        try{
            result=pjp.proceed();
            System.out.println("------end--------");
        }catch (Throwable e){
            e.printStackTrace();
        }
        return  result;
    }
}
