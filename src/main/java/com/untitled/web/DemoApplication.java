package com.untitled.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.untitled.util.TestUtil;

@Controller
public class DemoApplication {
	@RequestMapping("/")
	@ResponseBody
	String home() {
		TestUtil util = new TestUtil();
		
		return "Hello World!";
	}

}
