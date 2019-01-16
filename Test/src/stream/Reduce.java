package stream;

import java.util.List;

public class Reduce {
	
	public static void main(String[] args) {
		List<Unit> testList = Unit.getTestList();
		reduce(testList);
	}

	private static void reduce(List<Unit> list) {
		list.forEach(e -> {System.out.println("sku: " + e.getSku() + " qnty: " + e.getQnty());});
		int q = list.stream().map(Unit::getQnty).reduce(0, (a, b)->(a+b));
		System.out.println(q);
	}
	
}

