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
		for (int i = 0; i < limit; i++) {
			result[i] = -1;
		}
		bar(limit);
	}
	
	/**
	 * memorization of all the number takes 7 seconds or more
	 * @param n
	 */
	private static void bar(int n) {
		number[0] = number[1] = number[2] = 0;
		number[3] = 3;
		result[0] = result[1] = result[2] = 0;
		result[3] = 1;
		long max = 1;
//			System.out.println(LocalDateTime.now());
		for (int i = record; i < n; i++) {
//			System.out.println("-----------" + i + "----------");
			result[i] = foo(i);
			if (result[i] <= max) {
				number[i] = number[i - 1];
			} else {
				number[i] = i;
				max = result[i];
			}
//			System.out.println("number\t" + number[i]);
//			System.out.println("result\t" + result[i]);
		}
//			System.out.println(LocalDateTime.now());
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int i = in.nextInt();
			//d < N
			if (number[i] == i) {
				System.out.println(number[i - 1]);
			} else {
				System.out.println(number[i]);
			}
		}
		in.close();
	}
	
	private static int dividable(int temp, int x) {
		while (temp != 0 && temp % x == 0) {
			temp /= x;
		}
		if (temp == 1 || temp == 0) {
			return 0;
		}
		return temp;
	}

	private static long foo(int n) {
		// check divided by 2
		n = dividable(n, 2);
		// check divided by 5
		n = dividable(n, 5);
		if (n == 0) {
			return 0L;
		}
		// check if exits
		if (result[n] > -1) {
			return result[n];
		}
		long index = 0;
//		System.out.println(n);
		int dividend = 10;
		do {
			dividend %= n;
			index ++;
//			System.out.print(dividend + " ");
			if (1 == dividend) {
				return index;
			} else {
				dividend *= 10;
			}
		} while (true);
	}

}
