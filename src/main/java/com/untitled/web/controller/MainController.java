package com.untitled.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.untitled.data.entity.Person;
import com.untitled.data.repo.PersonRepository;
import com.untitled.security.entity.CustomUserDetails;

@Controller
public class MainController {
	@Autowired
	PersonRepository repo;

	@RequestMapping("/")
	String home(Model model) {
		return "index";
	}

	@RequestMapping("/user")
	String user(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			model.addAttribute("username", userDetails.getUsername());
		}

		return "user";
	}

	@RequestMapping("/admin")
	@ResponseBody
	String admin() {
		Person p = new Person();
		p.setName("Pedro");
		repo.count();
		repo.save(p);

		return "Hello World!" + repo.count();
	}

	@RequestMapping("/login.html")
	String login() {
		System.err.println("Login");
		return "login";
	}

	@RequestMapping("/login-error.html")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
	
	
	@RequestMapping(value={"/cases/**","/about/**","/timesheets/**", "/clients/**"})
	String defaultRoute(Model model) {
		return "index";
	}
	
	@RequestMapping("/api/user")
	@ResponseBody
	Authentication user() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
}
