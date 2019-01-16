package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * ���ڰ�����ͽ������
 * @author Administrator
 *
 */
public class OutputDateRange {
	
	public static void main(String[] args) {
		String[] head = new String[8];
		setHead(head, head.length - 1, 2, 4, true, "a");
		for (String s : head)
			System.out.println(s);
		setHead(head, head.length - 2, 2, 4, true, "b");
		for (String s : head)
			System.out.println(s);
		
		setHead(head, 0, 2, 4, false, "a");
		for (String s : head)
			System.out.println(s);
		setHead(head, 1, 2, 4, false, "b");
		for (String s : head)
			System.out.println(s);
	}

	
	/**
	 * @param hEAD
	 * @param start ��ʼindex
	 * @param seperateNum ���
	 * @param num ���ٸ�
	 * @param desc �Ƿ��� true����,false����
	 * @param str�̶��ַ���
	 */
	private static void setHead(String[] head, int start, int seperateNum, int num, boolean desc, String str) {
		long[][] dateRange = getDateRange();
		int[] array = new int[num];
		int increase = desc? -1 : 1;
		for (int i = 0; i < num; i++) {
			array[i] = start + i * seperateNum * increase;
		}
		for (int j = 0; j < num; j++) {
			head[array[j]] = dateStr(dateRange[j]) + str;
		}
	}
	
	private static String dateStr(long[] dateRange) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(dateRange[0]);
		String start = sdf.format(c.getTime());
		c.setTimeInMillis(dateRange[1]);
		String end = sdf.format(c.getTime());
		return start + "-" + end;
	}
	
	private static long[][] getDateRange() {
		Calendar current = Calendar.getInstance();
		Calendar start = (Calendar) current.clone();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//�ȱ������һ
		while (start.get(Calendar.DAY_OF_WEEK) > Calendar.MONDAY) {
			start.add(Calendar.DATE, -1);//��ǰ��һ��
		}
		//�ٱ�����ܵ�������
		do {
			start.add(Calendar.DATE, -1);//��ǰ��һ��
		} while (Calendar.THURSDAY != start.get(Calendar.DAY_OF_WEEK ));//ֱ����������
		//��һ���������洢
		long[][] arr = new long[4][];
		for (int i = 0; i < 4; i++) {
			Calendar end = (Calendar) start.clone();
			start.add(Calendar.DATE, -6);//��ǰ��7��
			long[] range = {start.getTimeInMillis(), end.getTimeInMillis()};
			arr[i] = range;
			String dStr = sdf.format(start.getTime()) + " " + sdf.format(end.getTime());
			System.out.println(dStr);
			start.add(Calendar.DATE, -1);//��ǰ��һ��,�����¸�����
		}
		return arr;
	}
}
