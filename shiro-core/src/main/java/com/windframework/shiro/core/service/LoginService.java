package com.windframework.shiro.core.service;

import com.windframework.shiro.core.entity.Role;
import com.windframework.shiro.core.entity.User;

public interface LoginService {

	User addUser(User user);

	Role addRole(Role role);

	User findByName(String name);

}
