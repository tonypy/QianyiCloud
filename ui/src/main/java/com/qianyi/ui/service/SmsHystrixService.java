package com.qianyi.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsHystrixService {

    @Autowired
    private SmsService smsService;

    @HystrixCommand(fallbackMethod = "fallbackSendMessage")
   public Object  sendMessage( String data){
      return smsService.sendMessage(data);
    }
    @HystrixCommand(fallbackMethod = "fallbackReport")
   public Object report( String data){
       return smsService.report(data);
    }
    @HystrixCommand(fallbackMethod = "fallbackReply")
    public Object reply( String data){
       return  smsService.reply(data);
    }

    public Object fallbackSendMessage(String data){
       String result= "SmsService SendMessage故障!";

        return result;
    }

    public Object fallbackReport(String data){
        String result= "SmsService Report故障!";

        return result;
    }
    public Object fallbackReply(String data){
      String result= "SmsService Reply故障!";
        return result;
    }
}
