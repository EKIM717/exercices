package hacker_rank.project_euler;

import java.util.Scanner;

public class Test {

	static int LENGTH = 10001;//maximum of T
	
	static int DIGIT_NUMBER = 3300;//maximum bits of N!
	
	static int[][] factorialResult = new int[LENGTH][DIGIT_NUMBER];
	
	static int[] finalResult = new int[LENGTH];

	/*
	 * initial
	 */
	static {
		factorialResult[0][0] = 1;
		finalResult[0] = 1;
//		for (int i = 1; i < LENGTH; i++) {
//			multipleBy2(i);
//			finalResult[i] = calc(factorialResult[i]);
//		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int a0 = in.nextInt();
			if (finalResult[a0] > 0) {
				System.out.println(finalResult[a0]);
			} else {
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
	
}
