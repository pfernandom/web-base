package com.untitled.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.untitled.entity.Person;
import com.untitled.repo.PersonRepository;

@Controller
public class DemoController {
	@Autowired
	PersonRepository repo;
	
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		Person p = new Person();
		p.setName("Pedro");
		repo.count();
		repo.save(p);
		
		return "Hello World!"+repo.count();
	}

}
