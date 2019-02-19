package hacker_rank.project_euler;

import java.util.Scanner;

public class P16_Power_Digit_Sum {

	static int LENGTH = 10001;// maximum times of 2

	static int DIGIT_NUMBER = 3300;// maximum times of 10

	static int[][] factorialResult = new int[LENGTH][DIGIT_NUMBER];

	static int[] finalResult = new int[LENGTH];

	/*
	 * initial
	 */
	static {
		factorialResult[0][0] = 1;
		finalResult[0] = 1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int a0 = in.nextInt();
			if (finalResult[a0] > 0) {
				System.out.println(finalResult[a0]);
			} else {
				// find the index of that hasn't been calculated
				int index = 0;
				for (int i = 1; i < LENGTH; i++) {
					if (finalResult[i] == 0) {
						index = i;
						break;
					}
				}
				for (int j = index; j <= a0; j++) {
					multipleBy2(j);
					finalResult[j] = calc(factorialResult[j]);
				}
				System.out.println(finalResult[a0]);
			}
		}
		in.close();
	}

	private static void multipleBy2(int k) {
		int carry = 0;
		for (int i = 0; i < DIGIT_NUMBER; i++) {
			int result = (factorialResult[k - 1][i] * 2 + carry);
			int remainder = result % 10;
			factorialResult[k][i] = remainder;
			carry = result / 10;
		}
	}

	static int calc(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	// use BigInteger
//	static long[] sumArray = new long[10001];
//	
//	
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		while (t-- > 0) {
//			int a0 = in.nextInt();
//			long a = foo(a0);
//			System.out.println(a);
//		}
//		in.close();
//	}
//
//	private static long foo(int a0) {
//		if (sumArray[a0] > 0) {
//			return sumArray[a0];
//		}
//		BigInteger a = new BigInteger("1");
//		BigInteger ten = new BigInteger("10");
//		BigInteger two = new BigInteger("2");
//		for (int i = 1; i <=a0; i++) {
//			a = a.multiply(two);
//		}
//		long sum = 0;
//		BigInteger[] quotientAndRemainder = null;
//		while (true) {
//			quotientAndRemainder = a.divideAndRemainder(ten);
//			sum += quotientAndRemainder[1].longValue();
//			if (quotientAndRemainder[0].equals(BigInteger.ZERO)) {
//				break;
//			} else {
//				a = quotientAndRemainder[0];
//			}
//		}
//		sumArray[a0] = sum;
//		return sum;
//	}
}
