package calendar;

import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
//		Calendar c = Calendar.getInstance();
////		c.add(Calendar.DATE, 305);
//		c.set(Calendar.MONTH, Calendar.FEBRUARY);
//		c.set(Calendar.DATE, 1);
//		System.out.println(c.get(Calendar.YEAR) + "-"  + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE));
//		c.roll(Calendar.DATE, -1);
//		System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.MONTH, 1);
		c1.set(Calendar.DATE, 1);
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2018);
		c2.set(Calendar.MONTH, 8);
		c2.set(Calendar.DATE, 1);
		int i = 0;
		System.out.println("c1:" + c1.get(Calendar.YEAR) + "-"  + (c1.get(Calendar.MONTH) + 1) + "-" + c1.get(Calendar.DATE));
		System.out.println("c2:" + c2.get(Calendar.YEAR) + "-"  + (c2.get(Calendar.MONTH) + 1) + "-" + c2.get(Calendar.DATE));
		System.out.println("--------------------------------");
		while (!(c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))) {
			c1.add(Calendar.MONTH, 1);
			System.out.println("c1:" + c1.get(Calendar.YEAR) + "-"  + (c1.get(Calendar.MONTH) + 1) + "-" + c1.get(Calendar.DATE));
			++i;
		}
		System.out.println(i);
		System.out.println(c1.get(Calendar.YEAR) + "-"  + (c1.get(Calendar.MONTH) + 1) + "-" + c1.get(Calendar.DATE));
	}
}
