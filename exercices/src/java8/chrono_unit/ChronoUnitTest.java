package java8.chrono_unit;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest {

	public static void main(String[] args) throws InterruptedException {
		LocalTime firstTime = LocalTime.now();
		Thread.sleep(100L);
		LocalTime secondTime = LocalTime.now();
		//相差时间,毫秒级别来衡量
		System.out.println(ChronoUnit.MILLIS.between(firstTime, secondTime));
		
	}

}
