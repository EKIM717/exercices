package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P26_Reciprocal_cycles {
	
	private static long[] result = new long[10000];
	private static int[] number = new int[10000];
	static int record = 4;
	
	static void bar (int n) {
		number[3] = 3;
		result[3] = 1;
		for (int i = record; i <= n; i++) {
			result[i] = foo(i);
			if (result[i] <= result[i - 1]) {
				number[i] = number[i - 1];
				result[i] = result[i - 1];
			} else {
				number[i] = i;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int i = in.nextInt();
			if (i >= record) {
				bar(i);
				record = i + 1;
			}
			System.out.println(number[i]);
		}
	}

	private static long foo(int n) {
		int bits = getDividerBit(n);
		int dividend = (int) Math.pow(10, bits);
		long index = 0;
//		System.out.println(n);
		List<Integer> list = new ArrayList<>();
		do {
			int remainder = dividend % n;
			if (0 == remainder) {
				return 0L;
			}
			if (list.contains(remainder)) {
				break;
			}
			list.add(remainder);
			int digit = 1;
			while ((remainder *= 10) < n) {
				digit++;
			}
			index += digit;
			dividend = remainder;
		} while (true);
		return index;
	}

	/**
	 * check if it is divisible by 2 or 5
	 * @param n
	 * @return
	 */
	private static boolean check(int n) {
		while (n % 2 == 0) {
			n /= 2;
		}
		if (n == 1) {
			return true;
		} else {
			while (n % 5 == 0) {
				n /= 5;
			}
			if (n == 1) {
				return true;
			}
		}
		return false;
	}
	
	private static int getDividerBit(int n) {
		int i = 1;
		while ((n /= 10) > 0) {
			i++;
		}
		return i;
	}

}
