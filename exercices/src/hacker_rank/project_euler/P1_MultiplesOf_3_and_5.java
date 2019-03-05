package hacker_rank.project_euler;

import java.util.Scanner;

public class P1_MultiplesOf_3_and_5 {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long t = in.nextLong();
		for (long a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			long numToDivide = n - 1;
			long threeSum = calc(numToDivide, 3);
			long fiveSum = calc(numToDivide, 5);
			long fifteenSum = calc(numToDivide, 15);
			System.out.println(threeSum + fiveSum - fifteenSum);
		}
		in.close();
	}

	private static long calc(long n, long divider) {
		//get the max quotient, above or equals to zero
		long times = n / divider;
		if (times == 0)
			return 0;
		// * calculate the sum of arithmetic sequence 
		long result = divider * (1 + times) * times / 2;
		return result;//calcSum(1 * divider, times * divider, times);

	}

}
