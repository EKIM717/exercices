package hacker_rank.project_euler;

import java.util.Scanner;

public class P31_Coin_sums {

	private static int[] cache = {1, 2, 5, 10, 20, 50, 100, 200};
	
	private static int[] result = new int[100001];

	private  static int modulo = (int)Math.pow(10, 9) + 7;
	
	static {
		result[0] = 1;
		result[1] = 1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int a0 = in.nextInt();
			System.out.println(foo(a0));
		}
	}

	private static char[] foo(int a0) {
		if (cache[cache.length - 1] < a0) {
			for (int i = 0; i < cache.length; i++) {
				result[a0] += (result[a0 - cache[i]]);
				result[a0] %= modulo;
			}
		} else {
			for (int i = 0; i < cache.length; i++) {
				if (cache[i] < a0) {
					break;
				} else {
					result[a0] += (result[a0 - cache[i]]);
					result[a0] %= modulo;
				}
			}
		}

		return null;
	}
}
