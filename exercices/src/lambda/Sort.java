package lambda;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Sort {

	public static void main(String[] args) throws InterruptedException {
		Obj o1 = new Obj();
		o1.setC(Calendar.getInstance());
		Thread.sleep(1 * 2);
		Obj o2 = new Obj();
		o2.setC(Calendar.getInstance());
		List<Obj> list = new ArrayList<>();
		list.add(o2);
		list.add(o1);
		//lambda表达式
		Collections.sort(list, (a, b)->-(new Long(a.getC().getTimeInMillis()).compareTo(b.getC().getTimeInMillis())));
		list.stream().forEach(e -> {System.out.println(e.getC().getTimeInMillis());});
		//传统表达式
//		Comparator<Obj> comp = new Comparator<Obj>() {
//			@Override
//			public int compare(Obj o1, Obj o2) {
//				return new Long(o1.getC().getTimeInMillis()).compareTo(o2.getC().getTimeInMillis());
//			}
//		};
//		List<Obj> l = list.stream().sorted(comp).collect(Collectors.toList());
//		l.stream().forEach(e -> {System.out.println(e.getC().getTimeInMillis());});
	}
}

class Obj implements Comparable<Obj> {
	private Calendar c;

	public Calendar getC() {
		return c;
	}

	public void setC(Calendar c) {
		this.c = c;
	}

	@Override
	public int compareTo(Obj o) {
		return new Long(this.c.getTimeInMillis()).compareTo(o.getC().getTimeInMillis());
	}
	
}
