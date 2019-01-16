package timeUnit;

import java.util.concurrent.TimeUnit;

public class TimeTest {

	public static void main(String[] args) {
		long l = TimeUnit.MILLISECONDS.convert(900L, TimeUnit.MICROSECONDS);
		System.out.println(l + " milliseconds");
	}
}
