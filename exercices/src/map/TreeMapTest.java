package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		System.out.println("-----------HashMap---��ʽ����ṹ,����洢------------");
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("a",1);
		hashMap.put("c",2);
		hashMap.put("d",3);
		hashMap.put("h",4);
		hashMap.put("aa",5);
		hashMap.put("abc", 6);
		hashMap.put("abcd", 6);
		for (Entry<String, Integer> s : hashMap.entrySet())
			System.out.println(s.getKey() + " - " + s.getValue());
		System.out.println("----------TreeMap--�������洢�ṹ,��ʵ��key������--------------");
		Map<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.put("a",1);
		treeMap.put("c",2);
		treeMap.put("d",3);
		treeMap.put("h",4);
		treeMap.put("aa",5);
		treeMap.put("abc", 6);
		treeMap.put("abcd", 6);
		for (Entry<String, Integer> s : treeMap.entrySet())
			System.out.println(s.getKey() + " - " + s.getValue());
		System.out.println("----------LinkedHashMap--���Ա�˳��洢�ṹ,������˳������--------------");
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		linkedHashMap.put("2",1);
		linkedHashMap.put("3",2);
		linkedHashMap.put("5",3);
		linkedHashMap.put("4",4);
		linkedHashMap.put("1",5);
		for (Entry<String, Integer> s : linkedHashMap.entrySet())
			System.out.println(s.getKey() + " - " + s.getValue());
	}
}
