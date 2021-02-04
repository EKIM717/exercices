package javaSE.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewSyntax {

	public static void test() {
		List<String> l = new ArrayList<>();
		for (int i = 0; i <5; i++)
			l.add("a");
		
		l.forEach(e -> {System.out.println(e);});
		
		Map<String, List<String>> m = new HashMap<>();
		m.put(null, l);
		
		m.get(null).forEach(e -> {System.out.println(e);});
	}
	
	public static void main(String[] args) {
		test();
	}
}
