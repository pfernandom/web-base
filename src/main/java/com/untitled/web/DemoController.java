package com.untitled.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.untitled.data.entity.Person;
import com.untitled.data.repo.PersonRepository;

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
	
	@RequestMapping("/test")
	String test(Model model) {
		model.addAttribute("name", "Peddro");
		return "test";
	}
	
	@RequestMapping("/admin")
	@ResponseBody
	String admin() {
		Person p = new Person();
		p.setName("Pedro");
		repo.count();
		repo.save(p);
		
		return "Hello World!"+repo.count();
	}

}
