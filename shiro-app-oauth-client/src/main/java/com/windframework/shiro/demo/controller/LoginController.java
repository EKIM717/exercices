package com.windframework.shiro.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

//	@Resource
//	private DefaultKaptcha kaptcha;

	@GetMapping(value = "/index")
	public String index() {
		return "/index";
	}

	@GetMapping(value = "/error")
	public String error() {
		return "error";
	}
	
	@GetMapping(value = "/403")
	public String unauthorizedPage() {
		return "403";
	}

	/**
	 * 退出的时候是get请求，主要是用于退出
	 * 
	 * @return
	 */
	@GetMapping(value = "/login")
	public String login(Model model) {
        model.addAttribute("msg","thymeleaf");
		return "login";
	}

	@GetMapping(value = "/logout")
	public String logout() {
		return "logout";
	}
}
