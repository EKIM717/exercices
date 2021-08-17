package com.windframework.shiro.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.windframework.shiro.demo.entity.Role;
import com.windframework.shiro.demo.entity.User;
import com.windframework.shiro.demo.service.LoginService;

@RestController
public class UserInfoController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * POST登录
	 * 
	 * @param map
	 * @return
	 */
	@PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
	public Map<String, Object> login(@RequestBody User user, Model model) {
		// 添加用户认证信息
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPassword());
		// 进行验证，这里可以捕获异常，然后返回对应信息
		SecurityUtils.getSubject().login(usernamePasswordToken);
		Map<String, Object> ret = new HashMap<>();
		ret.put("status", new Integer(200));
		ret.put("msg", "login ok!");
		return ret;
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/user/add")
	@RequiresPermissions("create")
	public String addUser(@RequestBody User user) {
		user = loginService.addUser(user);
		return "addUser is ok! \n" + user;
	}
	
	/**
	 * update用户
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/user/update")
	@RequiresPermissions("update")
	public String updateUser(@RequestBody User user) {
		user = loginService.addUser(user);
		return "addUser is ok! \n" + user;
	}

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return
	 */
	@PostMapping(value = "/role/add")
	public String addRole(@RequestBody Role role) {
		role = loginService.addRole(role);
		return "addRole is ok! \n" + role;
	}

	/**
	 * 注解的使用
	 * 
	 * @return
	 */
	@RequiresRoles("admin")
	@RequiresPermissions("create")
	@GetMapping(value = "/create")
	public String create() {
		return "Create success!";
	}

}
