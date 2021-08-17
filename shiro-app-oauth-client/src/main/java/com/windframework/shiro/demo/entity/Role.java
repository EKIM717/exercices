package com.windframework.shiro.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.crazycake.shiro.AuthCachePrincipal;

@Entity
@Table(name="t_role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 912281901812816121L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String roleName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="role")
	private List<Permission> permissions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	@Override
//	public String getAuthCacheKey() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}
