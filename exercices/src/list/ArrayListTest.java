package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import Finally.T;

public class ArrayListTest {

	public static void main(String[] args) {
		   List<Integer> list = new ArrayList<>();
	        list.add(1);
	        list.add(2);

	        List<Integer> list3 = list.subList(0, list.size());
	        list.add(3);
	        System.out.println(list.toString() + list3.toString());
//		long c1, c2;
//		c1 = c2 = 0L;
////		testForEachTime(c1, c2);
//		List<Integer> l = init(100);
//		l.clear();
//		for (int i : l) {
//			System.out.println(i);
//		}
//		List<String> l = new ArrayList<>();
//		for (int i = 0; i < 100; i++) {
//			l.add(i + "");
//		}
//		sub(l);
	}
	
	public static void sub(List<String> l) {
		l.subList(0, l.size());
		for (int i = 0; i < 5; i++) {
			List<String> sub = l.subList(i * 20, (i+1) * 20);
			for (String s : sub) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
	
	public static List<Integer> init(int count) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			list.add(i, i);
		}
		return list;
	}
	
	public static void testClear() {
		
	}
	
	public static void testForEachTime(long c1, long c2) {
		List<Byte> b = new LinkedList<Byte>();
		byte x = 0;
		//一亿就已经发生oom异常
		for (long i = 0; i < 1000000000; i++) {
			System.out.println("running");
			if (i%100000000 == 0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			b.add(x);
		}
		
		
		System.out.println("lambda stream---------");
		c1 = System.currentTimeMillis();
		b.forEach(e -> {Byte a = e;});
		c2 = System.currentTimeMillis();
		System.out.println((c2 - c1) + "ms\n");
		
		System.out.println("for each---------");
		c1 = System.currentTimeMillis();
		for (Byte e : b) {
			Byte a = e;
		}
		c2 = System.currentTimeMillis();
		System.out.println((c2 - c1) + "ms\n");
		
		System.out.println("for by get index without .size()---------");
		c1 = System.currentTimeMillis();
		int size = b.size();
		for (int i = 0; i < size; i++) {
			Byte a = b.get(i);
		}
		c2 = System.currentTimeMillis();
		System.out.println((c2 - c1) + "ms\n");
		
		
	}
	
	public static void testInsert(long c1, long c2) {
		System.out.println("------------insert from end---------------");
		List<String> b = new ArrayList<String>();
		System.out.println(c1 = Calendar.getInstance().getTimeInMillis());
		for (int i = 0; i < 100000; i++)
			b.add(i, "b" + i);
		System.out.println(c2 = Calendar.getInstance().getTimeInMillis());
		System.out.println(c2 - c1);
		
		List<String> a = new ArrayList<String>();
		System.out.println("------------insert using add---------------");
		System.out.println(c1 = Calendar.getInstance().getTimeInMillis());
		for (int i = 100001; i < 200000; i++)
			a.add("a" + i);
		System.out.println(c2 = Calendar.getInstance().getTimeInMillis());
		System.out.println(c2 - c1);
		
		System.out.println("------------结束---------------");
	}
}
