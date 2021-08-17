package com.windframework.shiro.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.windframework.shiro.demo.base.dao.BaseDao;
import com.windframework.shiro.demo.entity.SessionTemp;

public interface SessionTempDao extends BaseDao<SessionTemp, Long> {

	SessionTemp findByName(String name);

	@Query("from SessionTemp")
	List<SessionTemp> query(SessionTemp sessionTemp);
}
