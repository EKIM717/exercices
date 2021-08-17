package com.windframework.shiro.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.windframework.shiro.demo.dao.SessionTempDao;
import com.windframework.shiro.demo.entity.SessionTemp;
import com.windframework.shiro.demo.service.SessionTempService;

@Service
public class SessionTempServiceImpl implements SessionTempService {

	@Autowired
	private SessionTempDao sessionTempDao;
	
	@Override
	public SessionTemp findByName(String name) {
		return sessionTempDao.findByName(name);
	}

}
