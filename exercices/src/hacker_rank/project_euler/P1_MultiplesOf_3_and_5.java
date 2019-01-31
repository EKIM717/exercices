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
		long times = maxQuotient(n, divider);
		return calcSum(1 * divider, times * divider, times);

	}

	/**
	 * calculate the sum of arithmetic sequence 
	 * @param firstItem
	 * @param lastItem
	 * @param times
	 * @return
	 */
	private static long calcSum(long firstItem, long lastItem, long times) {
		if (times == 0)
			return 0;
		long result = (firstItem + lastItem) * times / 2;
		return result;
	}

	/**
	 * get the max quotient, above or equals to zero
	 * @param n
	 * @param divider
	 * @return
	 */
	private static long maxQuotient(long n, long divider) {
		for (long i = n; i > 0; i--) {
			if (i % divider == 0) {
				return i / divider;
			}
		}
		return 0;
	}

//	private static long sumOfevery15() {
//		long resultOf3 = calc(15, 3);
//		long resultOf5 = calc(15, 5);
//		return resultOf3 + resultOf5 - 15;
//	}
//
//	private static long numberOfDividerOf15() {
//		long numOfDivider3 = maxQuotient(15, 3);
//		long numOfDivider5 = maxQuotient(15, 5);
//		return numOfDivider3 + numOfDivider5 - 1;
//	}
}
