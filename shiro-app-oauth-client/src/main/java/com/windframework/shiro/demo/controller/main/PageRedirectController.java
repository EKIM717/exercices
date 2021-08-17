package com.windframework.shiro.demo.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/main")
public class PageRedirectController {

	@GetMapping(value = "redirect/order")
	public ModelAndView order() {
		return  new ModelAndView(new RedirectView("192.168.1.208:8082/index")); 
	}
	
	@GetMapping(value = "redirect/product")
	public RedirectView product() {
		RedirectView r = new RedirectView("192.168.1.208:8083/index");
		return r; 
	}
	
}
