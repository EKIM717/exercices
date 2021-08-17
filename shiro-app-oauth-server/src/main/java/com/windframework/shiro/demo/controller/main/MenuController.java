package com.windframework.shiro.demo.controller.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.windframework.shiro.demo.entity.Menu;
import com.windframework.shiro.demo.service.MenuService;

@Controller
@RequestMapping("/main")
public class MenuController {

	@Autowired
	private MenuService menuFuncSve;

	@RequestMapping(value = "getMenuURL")
	@ResponseBody
	public ResponseEntity<String> getMenu() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		Menu qObj = new Menu();
		qObj.setMenuCode("user");
		List<Menu> menu = menuFuncSve.query(qObj);
		System.out.println(JSON.toJSONString(menu));
		return new ResponseEntity<String>(JSON.toJSONString(menu), responseHeaders, HttpStatus.CREATED);
	}

	public static void main(String[] args) {
		Menu m = new Menu();
		m.setMenuCode("ssss");
		List<Menu> ml = new ArrayList<>();
		ml.add(m);
		System.out.println(JSON.toJSONString(ml));

	}

}
