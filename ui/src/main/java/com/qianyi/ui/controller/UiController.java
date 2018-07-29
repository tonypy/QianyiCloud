package com.qianyi.ui.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import com.qianyi.ui.service.SmsHystrixService;
import com.qianyi.ui.utils.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.qianyi.ui.domain.Person;
import com.qianyi.ui.service.PersonHystrixService;
import com.qianyi.ui.service.SomeHystrixService;

@RestController
public class UiController {
	@Autowired
	private SomeHystrixService someHystrixService;
	
	@Autowired
	private PersonHystrixService personHystrixService;

	@Autowired
	private SmsHystrixService smsHystrixService;

	@RequestMapping("/dispatch")
	public List<Person> sendMessage(@RequestBody String personName) {
		return personHystrixService.save(personName);
	}
	
	@RequestMapping(value = "/getsome",produces={MediaType.TEXT_PLAIN_VALUE})
	public String getSome(){
		return someHystrixService.getSome();
	}


	@RequestMapping(value = "/sendMessage")
	public Object sendMessages(@RequestBody String data){
		try {
			data= Base64Utils.encodeStr(data);
			data= URLEncoder.encode(data);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return  smsHystrixService.sendMessage(data);
	}

	@RequestMapping( value = "/report")
	public  Object report(@RequestBody String data){
		try {
			data= Base64Utils.encodeStr(data);
			data= URLEncoder.encode(data);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
      return  smsHystrixService.report(data);
	}

	@RequestMapping( value = "/reply")
	public  Object reply(@RequestBody String data)
	{
		try {
			data= Base64Utils.encodeStr(data);
			data= URLEncoder.encode(data);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return  smsHystrixService.reply(data);
	}
}
