package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日期按升序和降序输出
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
	 * @param start 起始index
	 * @param seperateNum 间隔
	 * @param num 多少个
	 * @param desc 是否降序 true降序,false升序
	 * @param str固定字符串
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
		//先变成星期一
		while (start.get(Calendar.DAY_OF_WEEK) > Calendar.MONDAY) {
			start.add(Calendar.DATE, -1);//向前推一天
		}
		//再变成上周的星期四
		do {
			start.add(Calendar.DATE, -1);//向前推一天
		} while (Calendar.THURSDAY != start.get(Calendar.DAY_OF_WEEK ));//直到是星期四
		//用一个数组来存储
		long[][] arr = new long[4][];
		for (int i = 0; i < 4; i++) {
			Calendar end = (Calendar) start.clone();
			start.add(Calendar.DATE, -6);//向前推7天
			long[] range = {start.getTimeInMillis(), end.getTimeInMillis()};
			arr[i] = range;
			String dStr = sdf.format(start.getTime()) + " " + sdf.format(end.getTime());
			System.out.println(dStr);
			start.add(Calendar.DATE, -1);//向前推一天,进入下个星期
		}
		return arr;
	}
}
