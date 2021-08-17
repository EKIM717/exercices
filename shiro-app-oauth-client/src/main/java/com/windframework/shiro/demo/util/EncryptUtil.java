package com.windframework.shiro.demo.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

public class EncryptUtil {

	/**
	 * 这是将传来的原始密码字符串进行加密的方法 salt是系统生成的密码盐，为32字符的字符串
	 * password则是用md5散列算法将原始密码+密码盐进行两次加密，
	 * 这里要与ShiroConfig类中的hashedCredentialsMatcher()方法里面的说明匹配 返回密码盐与加密密码的map
	 * 需要注意的就是第一个方法的散列算法与散列算法次数，需要与注册方法相匹配，不然登录会出问题
	 * 
	 * @param pwd
	 * @return
	 */
	public static Map<String, String> encrypt(String pwd) {
		// 加盐
		String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
		String password = new Md5Hash(pwd, salt, 2).toString();
		Map<String, String> map = new HashMap<>();
		map.put("salt", salt);
		map.put("password", password);
		return map;
	}
}
