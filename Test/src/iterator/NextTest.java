package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NextTest {

	public static void main(String[] args) {
		testToArray();
	}
	
	public static void testNext() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 11; i++) {
			list.add(i);
		}
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			Integer in = it.next();
			if(in.equals(9)) {
				it.remove();
			}
		}
		//上一个while循环已经把it的index移至最后,下面的while不会进入循环体
//		while(it.hasNext()) {
//		}
		for(Integer j : list) {
			System.out.println(j);
		}
	}
	
	public static void testToArray() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 11; i++) {
			list.add(i);
		}
//		Iterator<Integer> it = list.iterator();
		
		Integer[] iArr = list.toArray(new Integer[list.size()]);
		System.out.println(iArr.toString());
	}
	
}
