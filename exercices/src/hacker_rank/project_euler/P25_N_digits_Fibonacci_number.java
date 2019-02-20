package hacker_rank.project_euler;

import java.util.Scanner;

public class P25_N_digits_Fibonacci_number {

	static int LENGTH = 10000;

	static int DIGIT_NUMBER = 5001;

	static int[][] a = new int[LENGTH][DIGIT_NUMBER];

	static int[] result = new int[DIGIT_NUMBER];

	static long[][] fact = { { 0, 1 }, { 1, 1 } };

	private static long[][] matrixPow(int times) {
		if (times == 1)
			return fact;
		long[][] tmp = new long[2][2];
		tmp = initial(tmp, fact);
		for (int k = 1; k < times; k++) {
			tmp = matrixMultiple(tmp, fact);
		}
		return tmp;
	}

	private static long[][] matrixMultiple(long[][] arr1, long[][] arr2) {
		long[][] result = new long[arr2[0].length][arr1.length];
		for (int j = 0; j < arr2.length; j++) {
			for (int k = 0; k < arr1.length; k++) {
				int sum = 0;
				for (int i = 0; i < arr1[k].length; i++) {
					sum += arr1[k][i] * arr2[i][j];
				}
				result[j][k] = sum;
			}
		}
		return result;

	}

	private static long[][] initial(long[][] dest, long[][] source) {
		for (int i = 0; i < dest.length; i++) {
			for (int j = 0; j < dest[i].length; j++) {
				dest[i][j] = source[i][j];
			}
		}
		return dest;
	}

	static {
		a[0][0] = 1;
		a[1][0] = 1;
		for (int i = 2; i < LENGTH; i++) {
			a[i] = arrayAdd(a[i - 1], a[i - 2]);
		}
		for (int i = 2, index = i; i < DIGIT_NUMBER; i++) {
			index = bar(i, index);
			if (index == 543)
				System.out.println();
			
			System.out.println("i : " + i + " index : " + index);
		}
		long[][] cc = matrixPow(2);
		System.out.println(cc);

	}

	static int calcBit(int[] a) {
		int index = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] > 0) {
				return i + 1;
			}
		}
		return index;
	}

	private static int[] foo(int i) {
		if (i < LENGTH) {
			return a[i];
		} else {
			long[][] times = matrixPow(i - LENGTH + 1);
			return add(times, a[LENGTH - 1], a[LENGTH - 2]);
		}
	}
//
//	private static int[] add(int[] a, int[] b, int[] c, int[] d) {
//		return add(add(a, b), add(c, d));
//	}
	
	private static int[] add(long[][] times, int[] a, int[] b) {
		int n = 0;
		int m = n;
		for (int i = 0; i < times.length; i++) {
			m += times[i][0];
			n += times[i][1];
		}
		return arrayAdd(arrayMultiple(a, m), arrayMultiple(b, n));
	}
	
	private static int[] arrayMultiple(int[] a, int times) {
		int[] c = new int[a.length];
		int carry = 0;
		for (int i = 0; i < a.length; i++) {
			int result = (a[i] * times + carry);
			int remainder = result % 10;
			c[i] = remainder;
			carry = result / 10;
		}
		return c;
	}

	private static int[] arrayAdd(int[] a, int[] b) {
		int[] c = new int[a.length];
		int carry = 0;
		for (int i = 0; i < DIGIT_NUMBER; i++) {
			int result = (a[i] + b[i] + carry);
			int remainder = result % 10;
			c[i] = remainder;
			carry = result / 10;
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int a0 = in.nextInt();
			System.out.println(result[a0]);
		}
	}

	private static int bar(int i, int index) {
		while (true) {
			if (index == 10000) {
				System.out.println();
			}
			int[] a = foo(index);
			if (calcBit(a) == i) {
				result[i] = index;
				return index;
			}
			index++;
		}
	}
}
