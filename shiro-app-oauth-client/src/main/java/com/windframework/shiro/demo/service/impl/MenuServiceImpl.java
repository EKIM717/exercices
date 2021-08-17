package com.windframework.shiro.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.windframework.shiro.demo.dao.MenuDao;
import com.windframework.shiro.demo.entity.Menu;
import com.windframework.shiro.demo.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;

	public Menu addMenu(Menu menu) {
		return menuDao.save(menu);
	}

	public Menu findByName(String name) {
		Menu menu = menuDao.findByName(name);
		return menu;
	}

	@Override
	public List<Menu> query(Menu menu) {
		return menuDao.query(menu);
	}

}
