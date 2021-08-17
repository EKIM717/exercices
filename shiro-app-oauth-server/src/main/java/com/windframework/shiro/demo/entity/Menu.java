package com.windframework.shiro.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_menu")
public class Menu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5353746697971959785L;

	/**
	 * 必须要有ID列作为唯一标识,不然后抛异常
	 * Caused by: org.hibernate.AnnotationException: No identifier specified for entity: com.windframework.shiro.demo.entity.Department
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * 菜单名称
	 */
	@Column
	private String name;
	
	/**
	 * 上级菜单Id
	 */
	@Column
	private Integer parentId;
	
	/**
	 * 菜单代码
	 */
	@Column
	private String menuCode;
	
	/**
	 * 菜单请求路径
	 */
	@Column
	private String menuPath;
	
	/**
	 * 菜单序列
	 */
	@Column Integer menuOrder;
	
	/**
	 * 菜单权限
	 */
	@Column String menuPermission;

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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getMenuPermission() {
		return menuPermission;
	}

	public void setMenuPermission(String menuPermission) {
		this.menuPermission = menuPermission;
	}
	
	
	
}
