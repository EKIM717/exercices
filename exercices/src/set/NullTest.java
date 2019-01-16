package set;

import java.util.HashSet;
import java.util.Set;

public class NullTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		s.add("a");
		s.addAll(new HashSet<String>());
		System.out.println(s);
	}
}
