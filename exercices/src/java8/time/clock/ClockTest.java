package java8.time.clock;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ClockTest {

	public static void main(String[] args) {
		Instant instant = Instant.now();
		System.out.println("Instant.now()\t" + instant);
		
		ZoneId zoneId = ZoneId.of("Asia/Shanghai");
		ZonedDateTime zdt = instant.atZone(zoneId);
		System.out.println("ZonedDateTime\t" + zdt);
		
		Clock clock = Clock.fixed(instant, zoneId);
		System.out.println("fixed\t" + clock);
	}
	
}
