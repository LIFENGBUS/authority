package com.ieng.authority.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ieng.authority.pojo.User;
import com.ieng.authority.service.UserService;


@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView() {
		
		return "login";
	}
	
	@RequestMapping(value="/index")
	public String indexView() {
		
		return "index";
	}
	
	@RequestMapping(value="/demo")
	public String demo() {
		
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doLogin(String username, String password, HttpSession session) {
		Map<String, Object> map = userService.login(username, password);
		logger.debug("login user:\n\t\t {} {}; \n\t\t{}", username, password, map);
		if(map.get("user") != null) {
			session.setAttribute("LOGIN_USER", map.get("user"));
			session.setAttribute("ALLURL", map.get("allUrl"));
			return "redirect:/index";
		}
		return "redirect:/login";
	}
	
	

}
