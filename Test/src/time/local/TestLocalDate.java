package time.local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class TestLocalDate {

	public static void main(String[] args) {
		testOutput();
	}
	
	private static void testOutput() {
		LocalDate d = LocalDate.now();
		System.out.println("ΩÒÃÏ «: " + d);
		LocalTime t = LocalTime.now();
		System.out.println(t);
	}
	
	
}
