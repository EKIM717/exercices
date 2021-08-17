package com.windframework.shiro.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.crazycake.shiro.AuthCachePrincipal;

@Entity
@Table(name="t_user")
public class User implements Serializable, AuthCachePrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6029115297624264048L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	@Column
	private String password;
	
//	@Column
//	private String nickname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String getAuthCacheKey() {
		return this.name;
	}
	
	
	
}
