package integer;

import calendar.Test;

public class ModTest {

	public static void main(String[] args) {
		test(7,-4);
		test(-7,4);
	}
	
	private static void test(int i, int size) {
		System.out.println(i + " mod " + size + " = " + Math.floorMod(i, size));
		System.out.println(i + " / " + size + " = " + Math.floorDiv(i, size));
	}
}
