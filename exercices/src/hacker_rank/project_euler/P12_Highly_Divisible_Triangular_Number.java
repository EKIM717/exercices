package hacker_rank.project_euler;

import java.util.Scanner;

public class P12_Highly_Divisible_Triangular_Number {

	public static void main(String[] args) {
		int limit = 1001;
		int[] a = new int[limit];
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			int i = in.nextInt();
			System.out.println(getNum(a, i));
		}
		in.close();
	}

	private static int getNum(int[] a, int i) {
		if (a[i] == 0) {
			int a0 = 1;
			int temp = 0;
			int num = 0;
			while (temp <= i) {
				num = (a0 * (a0 + 1) / 2);
				temp = numberOfDivisors(num);
				a0++;
			}
			a[i] = num;
		}
		return a[i];
	}

	/**
	 * hint : if the prime factors of a number is a^n , b^m , c^q
	 * then the number of divisors is (n+1)(m+1)(q+1)
	 * 
	 */
	private static int numberOfDivisors(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2 || n == 3) {
			return 2;
		}
		int numberOfFactor = 1;
		//the factor of 2
		int i = 2;
		int count = 0;
		while (n % i == 0) {
			n /= i;
			count++;
		}
		numberOfFactor *= ++count;
		//the factor that is greater than 2
		for (i = 3; i * i <= n; i += 2) {
			int tmp = 0;
			while (n % i == 0) {
				n /= i;
				tmp++;
			}
			numberOfFactor *= ++tmp;
		}
		// n is a prime
		if (n > 1)
			return numberOfFactor * 2;

		return numberOfFactor;
	}

}
