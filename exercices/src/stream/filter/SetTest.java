package stream.filter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		
	}
	
	public static void test1() {
		List<String> list = Arrays.asList("a","b","b");
		Set<String> set = new HashSet<>();
		list.stream().filter(e -> (!set.contains(e)));
	}
}
