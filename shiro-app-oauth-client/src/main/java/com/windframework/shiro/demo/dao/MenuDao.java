package com.windframework.shiro.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.windframework.shiro.demo.base.dao.BaseDao;
import com.windframework.shiro.demo.entity.Menu;

public interface MenuDao extends BaseDao<Menu, Long> {

	Menu findByName(String name);

	@Query("from Menu")
	List<Menu> query(Menu menu);
	
}
