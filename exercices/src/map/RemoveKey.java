package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveKey {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "1");
		map.put(2, "2");
		map.put(3, "2");
		map.put(4, "4");
		test(map);
		System.out.println("方法执行完后");
		for (String s : map.values()) {
			System.out.println(s);
		}
	}
	
	public static void testRemoveKey(Map<Integer, String> map) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(3);
		System.out.println("进入方法后");
		map.keySet().removeAll(set);
		
		for (String s : map.values()) {
			System.out.println(s);
		}
	}
	
	public static void test(Map<Integer, String> map) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(3);
		System.out.println("进入方法后");
		map.keySet().removeAll(set);
		
		for (String s : map.values()) {
			System.out.println(s);
		}
	}
}
