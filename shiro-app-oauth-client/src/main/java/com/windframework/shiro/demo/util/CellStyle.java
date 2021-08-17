package com.windframework.shiro.demo.util;

import jxl.format.Colour;

/**
 * ExcelCell样式对象
 * 
 * @author lion
 * @date 2020年6月30日
 */
public class CellStyle {

	/**
	 * 内容
	 */
	private String context;
	
	/**
	 * 颜色
	 */
	private Colour color;
	
	public CellStyle(String context, Colour color) {
		this.context = context;
		this.color = color;
	}
	
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Colour getColor() {
		return color;
	}

	public void setColor(Colour color) {
		this.color = color;
	}
	
}
