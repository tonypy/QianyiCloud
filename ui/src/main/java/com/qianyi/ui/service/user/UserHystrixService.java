package com.qianyi.ui.service.user;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qianyi.ui.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserHystrixService {

    @Autowired
    UserService userService;

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false")},
            fallbackMethod = "fallbackselectByPrimaryKey")
    public  User selectByPrimaryKey(@PathVariable("id") Integer  id){

        return  userService.selectByPrimaryKey(id);
    }

    public User fallbackselectByPrimaryKey(Integer id){

        return new User();
    }
}
