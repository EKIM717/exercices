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
		// TemporalAccessor ת LocalDate
		String dateString = "2018 12 23";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
		TemporalAccessor ta = dtf.parse(dateString);
		System.out.println("LocalDate:" + LocalDate.from(ta));

		// TemporalAccessor ת LocalDateTime
		String dateTimeString = "2018 12 11 11:11:11";
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss");
		TemporalAccessor ta2 = dtf2.parse(dateTimeString);
		System.out.println("LocalDateTime:" + LocalDateTime.from(ta2));

		// ��ָ�������ȡһ��Year
		// ����������õ���ݷ�����,������������Ϊ2��29��,��ᱨ��
		// Exception in thread "main" java.time.DateTimeException: Invalid date
		// 'February 29' as '2011' is not a leap year
		// Year year1 = Year.of(2011);
		Year year = Year.of(2012);
		System.out.println("year :" + year);

		// ��Year��ȡYearMonth
		YearMonth yearMonth = year.atMonth(2);
		System.out.println("yearMonth :" + yearMonth);

		// YearMonthָ���յõ� LocalDate
		LocalDate localDate = yearMonth.atDay(29);
		System.out.println("localDate :" + localDate);

		// �ж��Ƿ�������
		System.out.println("isLeapYear :" + localDate.isLeapYear());
		
		
		DayOfWeek dayOfWeek = DayOfWeek.of(1);
		System.out.println("dayOfWeek :" + dayOfWeek);

		//�Զ����������2������
		//����һ�� MonthDay
		MonthDay monthDay = MonthDay.of(2, 29);
		LocalDate leapYear = monthDay.atYear(2012);
		System.out.println("leapYear :" + leapYear);
		
		//������������֮��������������԰�����ʱ�䵥λ��������ʱ���֮��ļ����
		long between = ChronoUnit.DAYS.between(localDate, leapYear);
		System.out.println("between :" + between);
	}

}
