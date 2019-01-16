package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorTest {

	public static void main(String[] args) {
		itTest();
	}
	
	
	private static void itTest() {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 1000; i++)
			set.add(i);
		
		Iterator<Integer> it1 = set.iterator();
		Iterator<Integer> it2 = set.iterator();
		System.out.println(it1.next());
		System.out.println(it2.next());
	}
}
