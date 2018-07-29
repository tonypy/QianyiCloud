package com.qianyi.ui.service;

import java.util.ArrayList;
import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qianyi.ui.domain.Person;

@Service
public class PersonHystrixService {

	@Autowired
	PersonService personService; 

	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"),
			@HystrixProperty(name = "execution.timeout.enabled", value = "false")},
			fallbackMethod = "fallbackSave")//1
	public List<Person> save(String name) {
		return personService.save(name);
	}
	
	public List<Person> fallbackSave(String name){ 
		List<Person> list = new ArrayList<>();
		Person p = new Person(name+"没有保存成功，Person Service 故障");
		list.add(p);
		System.out.println("失败");
		return list;
	}
}
