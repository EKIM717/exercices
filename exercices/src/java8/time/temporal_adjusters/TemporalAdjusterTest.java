package java8.time.temporal_adjusters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterTest {
	
	public static void main(String[] args) {
		//获取当前日期
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate : " + localDate);
		
		//计算当前月的第一天的日期
		LocalDate with = localDate.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("with firstDayOfMonth :" + with);

		// 计算当前月的第一个星期一的日期
		TemporalAdjuster temporalAdjuster1 = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
		LocalDate with1 = localDate.with(temporalAdjuster1);
		System.out.println("with " + DayOfWeek.MONDAY + " firstInMonth :" + with1);

		// 计算当前日期的下一个星期一的日期
		TemporalAdjuster temporalAdjuster2 = TemporalAdjusters.next(DayOfWeek.MONDAY);
		LocalDate with2 = localDate.with(temporalAdjuster2);
		System.out.println("with " + DayOfWeek.MONDAY + " nextInMonth :" + with2);
	}
	
}
