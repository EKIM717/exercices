package list;

import java.util.ArrayList;
import java.util.List;

public class RemoveTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			list.add(i);
		
		int size = list.size();
		do{
			list.remove(0);
		} while(--size > 0);
		System.out.println("finish");
	}
}
