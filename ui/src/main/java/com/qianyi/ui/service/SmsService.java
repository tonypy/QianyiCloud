package com.qianyi.ui.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "chgasms")
public interface SmsService {
    @RequestMapping(method = RequestMethod.POST, value = "/sendMessage",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Object sendMessage(@RequestBody String data);

    @RequestMapping(method = RequestMethod.POST, value = "/report",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Object report(@RequestBody String data);

    @RequestMapping(method = RequestMethod.POST, value = "/reply",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Object reply(@RequestBody String data);
}
