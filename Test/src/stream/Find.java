package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Find {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a","b","a","a","c","c");
		findFirst(list);
	}
	
	private static void findFirst(List<String> list) {
		Optional<String> s1 = list.stream().filter(e ->e.equals("b")).findFirst();
		Optional<String> s2 = list.stream().filter(e ->e.equals("c")).findAny();
		System.out.println("s1--->" + s1.get());
		System.out.println("s2--->" + s2.get());
	}
}
