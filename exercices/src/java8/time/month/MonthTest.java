package java8.time.month;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

public class MonthTest {

	public static void main(String[] args) {
		Year year = Year.of(1998);
		Month month = Month.of(2);
		YearMonth yearMonth = year.atMonth(month);
		LocalDate ld = yearMonth.atDay(30);
		System.out.println(ld);
		MonthDay monthDay = MonthDay.of(month, 30);
	}
	
}
