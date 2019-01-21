package java8.time.chrono_unit;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest {

	public static void main(String[] args) throws InterruptedException {
		LocalTime firstTime = LocalTime.now();
		//相差时间,毫秒级别来衡量
		LocalTime secondTime = firstTime.plus(100, ChronoUnit.MILLIS);
		System.out.println("firstTime和secondTime相差 " + ChronoUnit.MILLIS.between(firstTime, secondTime) + " 毫秒");
		//
		LocalTime thirdTime = firstTime.plus(100, ChronoUnit.SECONDS);
		System.out.println("firstTime和thirdTime相差 " + ChronoUnit.SECONDS.between(firstTime, thirdTime) + " 秒");
		//
		LocalTime fourthTime = firstTime.plus(100, ChronoUnit.MINUTES);
		System.out.println("firstTime和forthTime相差 " + ChronoUnit.MINUTES.between(firstTime, fourthTime) + " 分");
	}

}
