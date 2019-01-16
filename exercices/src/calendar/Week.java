package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Week {

	public static void main(String[] args) {
		String str  = new String("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		
		Calendar c = Calendar.getInstance();
		int weekDay = c.get(Calendar.DAY_OF_WEEK);
		
		Calendar from = (Calendar) c.clone();
		int fromWeekDay = from.get(Calendar.DAY_OF_WEEK);
		if (fromWeekDay > Calendar.SUNDAY)
			from.roll(Calendar.DAY_OF_WEEK, Calendar.SUNDAY - fromWeekDay);
		System.out.println(sdf.format(from.getTime()));
		Calendar to = (Calendar) c.clone();
		int toWeekDay = to.get(Calendar.DAY_OF_WEEK);
		if (toWeekDay < Calendar.SATURDAY)
			to.roll(Calendar.DAY_OF_WEEK, Calendar.SATURDAY - toWeekDay);
			
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println("" + from.get(Calendar.DAY_OF_WEEK) + (Calendar.SUNDAY == from.get(Calendar.DAY_OF_WEEK)));
		System.out.println("" + to.get(Calendar.DAY_OF_WEEK) + (Calendar.SUNDAY == to.get(Calendar.DAY_OF_WEEK)));
		System.out.println(Calendar.THURSDAY == c.get(Calendar.DAY_OF_WEEK));
		
//		c.roll(Calendar.DAY_OF_WEEK, 3);
		System.out.println(sdf.format(c.getTime()));
		c.add(Calendar.DATE, 8 - weekDay);
		System.out.println(sdf.format(c.getTime()));
		
	}
}
