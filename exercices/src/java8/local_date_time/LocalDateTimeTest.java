package java8.local_date_time;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println(ldt.plus(1, TemporalUnit));
	}
	
}
