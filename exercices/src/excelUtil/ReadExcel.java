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
		//�ַ�ȫ��ת���ɴ�д
		StringBuilder sb = new StringBuilder(s.toUpperCase());
		//��ת��ת��char����
		char[] cArr = sb.reverse().toString().toCharArray();
		int base = map.size();//����
		int index = -1;//���ս��
		for (int i = 0; i < cArr.length; i++) {
			if (!map.containsKey(cArr[i]))
				return -1;
			index += (map.get(cArr[i])) * Math.pow(base, i);
		}
		return index;
	}
	
}
