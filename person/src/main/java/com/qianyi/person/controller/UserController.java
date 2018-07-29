package com.qianyi.person.controller;


import com.qianyi.person.domain.User;
import com.qianyi.person.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/selectByPrimaryKey/{id}",method = RequestMethod.GET)
    public User  selectByPrimaryKey(@PathVariable("id") Integer id){

        return  userService.selectByPrimaryKey(id);
    }
}
