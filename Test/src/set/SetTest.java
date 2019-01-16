package set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
//		oomTest();
		System.out.println(setContainsAll());
	}
	
	public static void oomTest() {
		Set<Integer> a = new HashSet<Integer>();
		for (int i = 0; i < 1000000000; i++) {
			a.add(i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("finished");
	}
	
	public static void retainAll() {
		Set<String> s1 = new HashSet<String>();
		s1.add("a");
		s1.add("b");
		s1.add("c");
		Set<String> s2 = new HashSet<String>();
		s2.add("c");
		System.out.println(s1.retainAll(s2));
	}
	
	private static boolean setContainsAll() {
		List<String> s1 = Arrays.asList("a", "b", "c");
		Set<String> s2 = new HashSet<>();
		s2.add("a");
		s2.add("b");
		return s1.containsAll(s2);
	}
}
