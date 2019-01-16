package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveTest {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10; i++) {
			l.add(i);
			m.put(i, i);
		}
		Integer k = 0;
		Integer n = 9 ;
		for (Integer j : l) {
			System.out.println("µÚ" + j + "´Î");
			if (k >4)
				continue;
			m.keySet().remove(k);
			for (Integer in : m.keySet())
				System.out.print(in + " ");
			System.out.print("   |   ");
			if (n < 4)
				continue;
			m.keySet().remove(n);
			for (Integer in : m.keySet())
				System.out.print(in + " ");
			System.out.println(" ");
			 k++;
			 n--;
		}
	}
}
