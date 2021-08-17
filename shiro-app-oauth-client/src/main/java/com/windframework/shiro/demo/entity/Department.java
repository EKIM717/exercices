package com.windframework.shiro.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_department")
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9203324157279637080L;
	
	/**
	 * 必须要有ID列作为唯一标识,不然后抛异常
	 * Caused by: org.hibernate.AnnotationException: No identifier specified for entity: com.windframework.shiro.demo.entity.Department
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
//	@Column
//	private String manager;
	
}
