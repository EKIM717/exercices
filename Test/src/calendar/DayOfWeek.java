package calendar;

import java.util.Calendar;

public class DayOfWeek {

	public static void main(String[] args) {
		test2();
	}
	
	private static void test2() {
		long[][] arr = getDateRange();
		for (long[] i : arr) {
			System.out.println("��"+ i + "����Χ");
			for (long l : i)
				System.out.println(l);
		}
	}
	
	private static void test1() {
		Calendar current = Calendar.getInstance();
		System.out.println("Calendar.THURSDAY " + Calendar.THURSDAY);
		output(current);
		
		do {
			System.out.println("go back to one day ago");
			current.add(Calendar.DATE, -1);
			output(current);
		}//��ǰ��һ��
		while (Calendar.THURSDAY != current.get(Calendar.DAY_OF_WEEK ));
	}

	private static void output(Calendar current) {
		System.out.println("Today is " + current.getTime());
		System.out.println("day of week: " + current.get(Calendar.DAY_OF_WEEK));
	}
	
	private static long[][] getDateRange() {
		Calendar current = Calendar.getInstance();
		Calendar start = (Calendar) current.clone();
		//��ȡ��һ�������ĵ�����
		do {start.add(Calendar.DATE, -1);}//��ǰ��һ��
		while (Calendar.THURSDAY != start.get(Calendar.DAY_OF_WEEK ));//ֱ����������
		//��һ���������洢
		long[][] arr = new long[4][];
		for (int i = 0; i < 4; i++) {
			Calendar end = (Calendar) start.clone();
			dayBegin(start);
			dayEnd(end);
			end.set(Calendar.MILLISECOND, 999);
			long[] range = {start.getTimeInMillis(), end.getTimeInMillis()};
			arr[i] = range;
			start.add(Calendar.DATE, 7);
		}
		return arr;
	}
	
	public static void dayBegin(Calendar c) {
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
	}
	
	public static void dayEnd(Calendar c) {
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);
	}
	
}
