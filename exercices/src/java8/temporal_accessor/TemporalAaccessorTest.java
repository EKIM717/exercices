package java8.temporal_accessor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class TemporalAaccessorTest {

	public static void main(String[] args) {
		// TemporalAccessor 转 LocalDate
		String dateString = "2018 12 23";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
		TemporalAccessor ta = dtf.parse(dateString);
		System.out.println("LocalDate:" + LocalDate.from(ta));

		// TemporalAccessor 转 LocalDateTime
		String dateTimeString = "2018 12 11 11:11:11";
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss");
		TemporalAccessor ta2 = dtf2.parse(dateTimeString);
		System.out.println("LocalDateTime:" + LocalDateTime.from(ta2));

		// 用指定的年获取一个Year
		// 如果这里设置的年份非闰年,下面设置日期为2月29日,则会报错
		// Exception in thread "main" java.time.DateTimeException: Invalid date
		// 'February 29' as '2011' is not a leap year
		// Year year1 = Year.of(2011);
		Year year1 = Year.of(2012);
		System.out.println("year1 :" + year1);

		// 从Year获取YearMonth
		YearMonth yearMonth = year1.atMonth(2);
		System.out.println("yearMonth :" + yearMonth);

		// YearMonth指定日得到 LocalDate
		LocalDate localDate = yearMonth.atDay(29);
		System.out.println("localDate :" + localDate);

		// 判断是否是闰年
		System.out.println("isLeapYear :" + localDate.isLeapYear());
	}

}
