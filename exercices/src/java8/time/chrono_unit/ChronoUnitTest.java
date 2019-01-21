package java8.time.chrono_unit;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest {

	public static void main(String[] args) throws InterruptedException {
		LocalTime firstTime = LocalTime.now();
		//���ʱ��,���뼶��������
		LocalTime secondTime = firstTime.plus(100, ChronoUnit.MILLIS);
		System.out.println("firstTime��secondTime��� " + ChronoUnit.MILLIS.between(firstTime, secondTime) + " ����");
		//
		LocalTime thirdTime = firstTime.plus(100, ChronoUnit.SECONDS);
		System.out.println("firstTime��thirdTime��� " + ChronoUnit.SECONDS.between(firstTime, thirdTime) + " ��");
		//
		LocalTime fourthTime = firstTime.plus(100, ChronoUnit.MINUTES);
		System.out.println("firstTime��forthTime��� " + ChronoUnit.MINUTES.between(firstTime, fourthTime) + " ��");
	}

}
