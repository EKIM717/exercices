package hacker_rank.project_euler;

import java.util.Scanner;

public class P31_Coin_sums {

	private static int[] cache = {1, 2, 5, 10, 20, 50, 100, 200};
	
	private static int[] result = new int[100001];
	
	static {
		result[1] = 1;
		result[2] = 2;
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
		int count = 0;
		//divided by i
		int i = 0;
		for (; i < cache.length; i++) {
			if (cache[i] > a0)
				break;
			if (a0 % cache[i] == 0) {
				count++;
			}
		}
		i--;
		//
		
		return null;
	}
}
