package com.qianyi.ui.controller;

import com.qianyi.ui.domain.User;
import com.qianyi.ui.service.user.UserHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    UserHystrixService userHystrixService;

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User selectByPrimaryKey(@PathVariable("id") Integer id){

        return  userHystrixService.selectByPrimaryKey(id);
    }
}
