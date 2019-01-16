package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 30);
		c.add(Calendar.MONTH, -8);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(c.getTime()));
		int num2 = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(num2);
		
	}
}
