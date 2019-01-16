package util;

import java.util.Objects;

public class NullUtil {
	
	
	public static void main(String[] args) {
//		String s = null;
//		Float f = null;
//		Integer i = new Integer(0);
//		System.out.println(isNull(s, f, i));
		
		Integer i = new Integer (1024);
		Integer j = new Integer (1024);
		System.out.println(Objects.equals(i, j));
	}
	
	private static boolean equal(Object o) {
		return Objects.equals(null, o);
	}

	/**
	 * 用于判断多个对象不能同时为null
	 * @param os
	 * @return
	 */
	public static boolean isNull(Object... os) {
		for (Object o : os) {
			if (!equal(o))
				return false;
		}
		return true;
	}
}
