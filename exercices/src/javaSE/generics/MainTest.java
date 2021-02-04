package javaSE.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainTest {

	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		List<Integer> i = new LinkedList<Integer>();
		Set<String> se = new HashSet<String>();
		se.add("dd");
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("s", 2);
		m.put("ss", 2);
		m.put("sss", 2);
		System.out.println("s " + MainTest.emptyCollection(s));
		System.out.println("i " + MainTest.emptyCollection(i));
		System.out.println("se " + MainTest.emptyCollection(se));
		System.out.println("m " + MainTest.emptyCollection(m.keySet()));
	}
	
	public static <T> boolean emptyCollection(Collection<T> c) {
		if (null == c || 0 == c.size())
			return true;
		return false;
	}
}
