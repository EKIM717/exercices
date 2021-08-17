package com.windframework.shiro.demo.service;

import java.util.List;

import com.windframework.shiro.demo.entity.Menu;

public interface MenuService {

	Menu addMenu(Menu user);

	Menu findByName(String name);
	
	List<Menu> query(Menu menu);
	
}
