package com.windframework.shiro.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.windframework.shiro.core.base.dao.BaseDao;
import com.windframework.shiro.core.entity.User;

public interface UserDao extends BaseDao<User, Long> {
	
	/**
	 * 根据用户名查找
	 * @param name
	 * @return
	 */
	User findByName(String name);
	
	@Query("from User")
	List<User> query(User user);
	
}
