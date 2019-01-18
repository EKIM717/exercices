package java8.temporal_accessor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
		Year year = Year.of(2012);
		System.out.println("year :" + year);

		// 从Year获取YearMonth
		YearMonth yearMonth = year.atMonth(2);
		System.out.println("yearMonth :" + yearMonth);

		// YearMonth指定日得到 LocalDate
		LocalDate localDate = yearMonth.atDay(29);
		System.out.println("localDate :" + localDate);

		// 判断是否是闰年
		System.out.println("isLeapYear :" + localDate.isLeapYear());
		
		
		DayOfWeek dayOfWeek = DayOfWeek.of(1);
		System.out.println("dayOfWeek :" + dayOfWeek);

		//自动处理闰年的2月日期
		//创建一个 MonthDay
		MonthDay monthDay = MonthDay.of(2, 29);
		LocalDate leapYear = monthDay.atYear(2012);
		System.out.println("leapYear :" + leapYear);
		
		//计算两个日期之间的天数，还可以按其他时间单位计算两个时间点之间的间隔。
		long between = ChronoUnit.DAYS.between(localDate, leapYear);
		System.out.println("between :" + between);
	}

}
