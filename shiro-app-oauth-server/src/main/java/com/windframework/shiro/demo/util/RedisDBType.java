package com.windframework.shiro.demo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义每个模块使用的redis数据库序号
 * @author ljj
 *
 */
public enum RedisDBType {

	NULL(-1),
	/**
	 * 产品模块
	 */
	PRODUCT(0),
	/**
	 * 销售模块
	 */
	SALE(1),
	/**
	 * 账号模块
	 */
	ACCOUNT(2),
	/**
	 * 采购模块
	 */
	PURCHASE(3);

	private Integer index;

	public Integer getIndex() {
		return index;
	}

	private RedisDBType(Integer index) {
		this.index = index;
	}

	public static RedisDBType fromName(String name) {
		if (StrUtil.isEmpty(name)) {
			return NULL;
		}
		for (RedisDBType c : RedisDBType.values()) {
			if (c.name().equalsIgnoreCase(name)) {
				return c;
			}
		}
		return RedisDBType.NULL;
	}

	public static RedisDBType fromCode(Integer index) {
		if (null == index) {
			return NULL;
		}
		for (RedisDBType c : RedisDBType.values()) {
			if (c.index == index) {
				return c;
			}
		}
		return RedisDBType.NULL;
	}

	public static RedisDBType[] useableValues() {
		List<RedisDBType> values = new ArrayList<RedisDBType>();
		for (RedisDBType value : RedisDBType.values()) {
			if (!value.name().equalsIgnoreCase(RedisDBType.NULL.name())) {
				values.add(value);
			}
		}
		return values.toArray(new RedisDBType[values.size()]);
	}

}
