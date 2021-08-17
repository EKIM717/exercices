package com.windframework.shiro.demo.service;

import com.windframework.shiro.demo.entity.Role;
import com.windframework.shiro.demo.entity.User;

public interface LoginService {

	User addUser(User user);

	Role addRole(Role role);

	User findByName(String name);

}
