package java8.time.year;

import java.time.LocalDate;
import java.time.Year;

public class YearTest {

	public static void main(String[] args) {
		Year year = Year.of(1998);
		LocalDate ld = year.atDay(3);
		System.out.println(ld);
	}
}
