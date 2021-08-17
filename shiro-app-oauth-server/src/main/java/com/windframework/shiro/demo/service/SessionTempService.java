package com.windframework.shiro.demo.service;

import com.windframework.shiro.demo.entity.SessionTemp;

public interface SessionTempService {

	SessionTemp findByName(String name);
	
}
