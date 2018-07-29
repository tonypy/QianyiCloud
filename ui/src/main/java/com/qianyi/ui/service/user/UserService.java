package com.qianyi.ui.service.user;

import com.qianyi.ui.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient("person")
public interface UserService {


    @RequestMapping(method = RequestMethod.GET, value = "/user/selectByPrimaryKey/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
      User selectByPrimaryKey(@PathVariable("id") Integer  id);
}
