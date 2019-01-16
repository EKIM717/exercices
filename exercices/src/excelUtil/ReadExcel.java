package excelUtil;

import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
	
	private static Map<Character, Integer> map = null;
	
	static {
		map = new HashMap<Character, Integer>();
		int index = 1;
		for(char c = 'A'; c <='Z'; c++)
			map.put(c, index++);
	}
	
	public static final int getIndex(String s) {
		if (null == s || s.equals(""))
			return -1;
		//字符全部转换成大写
		StringBuilder sb = new StringBuilder(s.toUpperCase());
		//反转后转成char数组
		char[] cArr = sb.reverse().toString().toCharArray();
		int base = map.size();//基数
		int index = -1;//最终结果
		for (int i = 0; i < cArr.length; i++) {
			if (!map.containsKey(cArr[i]))
				return -1;
			index += (map.get(cArr[i])) * Math.pow(base, i);
		}
		return index;
	}
	
}
