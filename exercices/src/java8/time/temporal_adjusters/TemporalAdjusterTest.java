package java8.time.temporal_adjusters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterTest {
	
	public static void main(String[] args) {
		//��ȡ��ǰ����
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate : " + localDate);
		
		//���㵱ǰ�µĵ�һ�������
		LocalDate with = localDate.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("with firstDayOfMonth :" + with);

		// ���㵱ǰ�µĵ�һ������һ������
		TemporalAdjuster temporalAdjuster1 = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
		LocalDate with1 = localDate.with(temporalAdjuster1);
		System.out.println("with " + DayOfWeek.MONDAY + " firstInMonth :" + with1);

		// ���㵱ǰ���ڵ���һ������һ������
		TemporalAdjuster temporalAdjuster2 = TemporalAdjusters.next(DayOfWeek.MONDAY);
		LocalDate with2 = localDate.with(temporalAdjuster2);
		System.out.println("with " + DayOfWeek.MONDAY + " nextInMonth :" + with2);
	}
	
}
