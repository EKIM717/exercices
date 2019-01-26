package java8.time.local_date_time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println(ldt.plus(1, ChronoUnit.DAYS));
		
		System.out.println(ldt.getChronology());
	}
	
}
