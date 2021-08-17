/**
 * @auther Lijk
 * 2011-8-25
 */
package com.windframework.shiro.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 字符串工具类
 * @author Lijk
 *
 */
public final class StrUtil {
	
	public static final String SEPERATOR = "|"; 

	/**
	 * 是否为空<br>
	 * 包括Null和""
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str))
			return true;
		return false;
	}

	/**
	 * 去掉前后无意义的字符<br>
	 * 空格等
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		if (str == null)
			return null;
		return str.trim();
	}
	
	public static String dealNullStr(String str) {
		String ret = "";
		ret = str == null ? "" : str;
		return ret;
	}
	
	/**
	 * replaceAll("\\s*", "")可以替换大部分空白字符<br>
	 * 不限于空格 \s 可以匹配空格、制表符、换页符等空白字符的其中任意一个
	 * replaceAll("　", "")用于替换全角的空格字符
	 * @param str
	 * @return
	 */
	public static String replaceSpace(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("\\s*", "").replaceAll("　", "");
	}
	
	/**
	 * 判断是否含有中文
	 * @param str
	 * @return
	 */
	public static boolean isChineseChar(String str) {
		boolean temp = false;
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			temp = true;
		}
		return temp;
	}

	/**
	 * 判断是否为数字字符，不是则返回true ,是则返回false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean notNumberStr(String str) {
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (!isNumberic(c[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断该字符是否为数学字符（含小数点），是则返回true，不是则返回false
	 * 
	 * @param c
	 * @return
	 */
	private static boolean isNumberic(char c) {
		if ((c >= '0' && c <= '9') || c == '.') {
			return true;
		}
		return false;
	}
	
	/**
	 * 用于dao的in语句<br>
	 * 返回一个形式如:'a','b','c'的字符串,<br>
	 * 如果Collection为空,则返回  ''
	 * @param subStr
	 * @return
	 */
	public static String constructInStatement(Collection<String> subStr) {
		StringBuffer sb = new StringBuffer("'");
		String[] array = new String[subStr.size()];
		subStr.toArray(array);//将collection的内容存入array数组中
		if(null != array && array.length > 0) {
			for(int i = 0; i < array.length; i++) {
				if(i == (array.length - 1)) {
					sb.append(array[i]);
				} else {
					sb.append(array[i] + "', '");
				}
			}
		}
		sb.append("'");
		return sb.toString();
	}
	
	/**
	 * 整形的参数
	 * @param intCollection
	 * @return
	 */
	public static String constructInStatementInt(Collection<Integer> c) {
		StringBuffer sb = new StringBuffer("");
		Integer[] array = c.toArray(new Integer[c.size()]);
		c.toArray(array);//将collection的内容存入array数组中
		if(null != array && array.length > 0) {
			for(int i = 0; i < array.length; i++) {
				if(i == (array.length - 1)) {
					sb.append(array[i]);
				} else {
					sb.append(array[i] + ", ");
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 去重
	 * @param array
	 * @return
	 */
	public static <T> Set<T> distinct(T[] array) {
		if (null == array)
			return null;
		//for循环去重
		Set<T> set = new HashSet<>();
		for (T s : array)
			set.add(s);
		
		return set;
	}
	
	/**
	 * 返回一个size等于page*pageCount的collection对象,size不足就以""空字符串表示
	 * @param c (Collection对象)
	 * @param page(页数)
	 * @param pageCount(每页数量)
	 * @return
	 */
	public static List<String> constructInStatement(Collection<String> c, int page, int pageCount) {
		List<String> list = new ArrayList<String>();
		//把Set或者List的内容赋值给list
		for(String s : c) {
			list.add(s);
		}
		//少的用NULL补上
		for(int i = 0; i < page*pageCount-c.size(); i++) {
			list.add("NULL");
		}
		return list;
	}
	
	/**
	 * 构造PreparedStatement的IN语句的问号
	 * @param limit
	 * @return
	 */
	public static String sqlInStatement(int limit) {
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i < limit; i++) {
			sb.append("?,");
		}
		String s = sb.toString();
		return s.substring(0,s.lastIndexOf(','));//返回去掉最后一个逗号的字符串
	}
	
	/**
	 * 拼接字符串(默认添加"|"作为拼接符)
	 * @param seperator
	 * @param strs
	 * @return
	 */
	public static String concatKey(Object... strs) {
		return Arrays.stream(strs).map(e -> String.valueOf(e)).collect(Collectors.joining(SEPERATOR));
	}
	
	/**
	 * 单纯拼接字符串,无拼接符
	 * @param strs
	 * @return
	 */
	public static String concatStr(Object... strs) {
		return Arrays.stream(strs).map(e -> String.valueOf(e)).collect(Collectors.joining());
	}
	
	/**
	 * 拼接字符串, 可使用自定义拼接符, 来拼接
	 * @param seperator
	 * @param strs
	 * @return
	 */
	public static String concat(StringBuilder seperator, Object... strs) {
		String sep = (null == seperator)? SEPERATOR : seperator.toString();
		return Arrays.stream(strs).map(e -> String.valueOf(e)).collect(Collectors.joining(sep));
	}
	
	/**
	 * 去重,去掉无用字符
	 * @param str
	 * @return
	 */
	public static String[] reduce(String[] str) {
		if (null == str || 0 == str.length)
			return new String[0];
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		for (String s : str) {
			if (isEmpty(s) || isEmpty(s.trim()))
				continue;
			if (set.contains(s))
				continue;
			set.add(s);
			list.add(s);
		}
		return list.toArray(new String[list.size()]);
	}
	
	/**
	 * 下划线转驼峰法(默认小驼峰)
	 *
	 * @param line 源字符串
	 * @param smallCamel 大小驼峰,是否为小驼峰(驼峰，第一个字符是大写还是小写)
	 * @return 转换后的字符串
	 */
	public static String convertCamel(String line, boolean ... smallCamel) {
		if (line == null || "".equals(line)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
		Matcher matcher = pattern.matcher(line);
		// 匹配正则表达式
		while (matcher.find()) {
			String word = matcher.group();
			// 当是true 或则是空的情况
			if ((smallCamel.length == 0 || smallCamel[0]) && matcher.start() == 0) {
				sb.append(Character.toLowerCase(word.charAt(0)));
			} else {
				sb.append(Character.toUpperCase(word.charAt(0)));
			}

			int index = word.lastIndexOf('_');
			if (index > 0) {
				sb.append(word.substring(1, index).toLowerCase());
			} else {
				sb.append(word.substring(1).toLowerCase());
			}
		}
		return sb.toString();
	}
	
	public static String[] split(String str, String seperator) {
		return str.split(seperator);
	}
	
	public static String[] splitKey(String str) {
		return str.split("\\" + SEPERATOR);
	}

}
