package time.local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class TestLocalDateTime {
	public static void main(String[] args) {
		testLong();
	}
	
	
	private static void testLong() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateStr = date.format(formatter);
		long millis = date.getLong(ChronoField.MILLI_OF_DAY);
		System.out.println(dateStr + " " + millis);
	}
}
