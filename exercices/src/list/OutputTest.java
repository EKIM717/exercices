package list;

import java.util.ArrayList;
import java.util.List;

public class OutputTest {
	public static void main(String[] args) {
		testStr();
	}
	
	private static void testStr() {
		String s = "asfasofho";
		System.out.println(s.toString());
	}

	private static void output() {
		List<String> l = new ArrayList<>();
		l.add("a");
		l.add("b");
		List<String> d = new ArrayList<>();
		d.add("a");
		d.add("c");
		l.removeAll(d);
		System.out.println(l);
	}
}
