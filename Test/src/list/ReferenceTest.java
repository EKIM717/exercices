package list;

import java.util.LinkedList;
import java.util.List;

public class ReferenceTest {

	public static void main(String[] args) {
		List<String> l = new LinkedList<>();
		add(l);
		System.out.println(l);
	}
	
	private static void add(List<String> l) {
		l.add("a");
	}
}
