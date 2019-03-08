package hacker_rank.project_euler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P26_Reciprocal_cycles {
	static int limit = 10001;
	private static long[] result = new long[limit];
	private static int[] number = new int[limit];
	static int record = 4;
	
	static {
		bar(limit);
	}
	
	/**
	 * memorization of all the number takes 7 seconds or more
	 * @param n
	 */
	private static void bar(int n) {
		number[3] = 3;
		result[3] = 1;
		for (int i = record; i < n; i++) {
			System.out.println("-----------" + i + "----------");
			System.out.println(LocalDateTime.now());
			result[i] = foo(i);
			System.out.println(LocalDateTime.now());
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
//			if (i >= record) {
//				bar(i);
//				record = i + 1;
//			}
			if (number[i] == i) {//d < N
				System.out.println(number[i - 1]);
			} else {
				System.out.println(number[i]);
			}
		}
		in.close();
	}

	private static long foo(int n) {
		if (check(n)) {
			return 0L;
		}
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
