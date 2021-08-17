/**
 * 
 */
package com.windframework.shiro.demo.base.response;

import com.windframework.shiro.demo.base.enumerate.SuperEnum;

/**
 * 服务返回结果
 * @author Lijk
 *
 */
public enum SveResult implements SuperEnum {

	SUCCESS(1, "成功"),
	FAIL(2, "失败");

	private Integer code;

	private String msg;
	
	private SveResult(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	@Override
	public Integer getCode() {
		return code;
	}
	
	@Override
	public String getMsg() {
		return msg;
	}

}
