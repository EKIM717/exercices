package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * ¡ŸΩÁ÷µ≤‚ ‘
 * @author Administrator
 *
 */
public class LimitValue {
	
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(0L);
		c.add(Calendar.DATE, -1);
		System.out.println(c.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(c.getTime()));
		
	}

}
