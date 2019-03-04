package loop;

public class TT {

	static int l = 4000;
	static int p = 7000;
	static int f = 6000;
	static int s = 7000;
	private void mian() {
		foo(5, 1);
	}
	
	private static void foo (float profit, int count) {
		for (int i = 1; i < 100000; i++) {
			int sum = (int) (l * Math.round(i / 200d) + p * Math.round(i / 500d) + f * Math.round(i / 2000d) + s * count);
			if (i * count * profit == sum) {
				System.out.println(i);
			}
		}
	}
}
