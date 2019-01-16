package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		List<String> l = Arrays.asList("a", "aa", "bb", "ba");
//		List<String> a = new ArrayList<>();
//		l.stream().filter(e -> !(e.indexOf('a') > -1))
//		.forEach(e -> a.add(e));
//		
//		a.stream().forEach(e -> System.out.println(e));
//		
//		System.out.println();
		
		String sku = "a";
		String platform = "b";
		String site = "c";
		Set<String> distributeMap = new HashSet<String>();
		distributeMap.add("a|bb|b|c");
		l.stream()
		.map(s -> s = sku + "|" + s + "|" + platform + "|" + site)
		.filter(s -> (!distributeMap.contains(s)))
		.forEach(s -> exe(s, distributeMap));
		
//		distributeMap.stream().forEach(s -> System.out.println(s));
		
	}
	
	private static void exe(String s, Set<String> distributeMap) {
		System.out.println(s);
		distributeMap.add(s);
	}
	
	private  static boolean judge(Set<String> distributeMap, String s, String sku, String platform , String site) {
		String key = sku + "|" + s + "|" + platform + "|" + site;
		if (!distributeMap.contains(key))
			return true;
		return false;
			
	}
	
}
