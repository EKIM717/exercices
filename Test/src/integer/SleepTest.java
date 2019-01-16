package integer;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		int i = 1;
		sleep(i);
		long j = 1L;
		sleep(j);
	}
	
	private static void sleep(int i) throws InterruptedException {
		System.out.println("       int       ");
		Thread.sleep(i);
	}
	
	private static void sleep(long i) throws InterruptedException {
		System.out.println("       long       ");
		Thread.sleep(i);
	}
}
