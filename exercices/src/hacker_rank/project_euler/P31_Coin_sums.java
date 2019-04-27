package hacker_rank.project_euler;

import java.util.Arrays;
import java.util.Scanner;

public class P31_Coin_sums {

	static int limit = 100001;

	private static int[] cache = { 1, 2, 5, 10, 20, 50, 100, 200 };

	private static int[] result = new int[limit];
	private static boolean[] record = new boolean[limit];

	private static int modulo = (int) Math.pow(10, 9) + 7;

	static {
		Arrays.fill(result, 0);
		Arrays.fill(record, false);
		record[0] = true;
		result[0] = 1;
		for (int i = 0; i < cache.length; i++) {
			System.out.println("----------------------");
			for (int j = cache[i]; j < 21;j++) {
				result[j] += result[j - cache[i]];
				System.out.println("result[" + j + "]= " + result[j]);
				result[j] %= modulo;
			}
		}
		for (int i = 0; i < 21; i++) {
			System.out.println("result[" + i + "]= " + result[i]);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int a0 = in.nextInt();
			System.out.println(foo(a0));
		}
		in.close();
	}

	private static int foo(int a0) {
		if (record[a0]) {
			return result[a0];
		}
		
		for (int i = 0; i < cache.length; i++) {
			if (cache[i] > a0)
				break;
			result[a0] += foo(a0 - cache[i]);
			result[a0] %= modulo;
			record[a0] = true;
		}
		return foo(a0);
	}
}
