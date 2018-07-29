package com.qianyi.person.service;

import com.qianyi.person.domain.User;
import com.qianyi.person.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
   private UserMapper userMapper;
   public User selectByPrimaryKey(Integer id){

       return userMapper.selectByPrimaryKey(id);
   }
}
