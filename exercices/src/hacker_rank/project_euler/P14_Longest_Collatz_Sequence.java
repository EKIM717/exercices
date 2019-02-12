package hacker_rank.project_euler;

import java.util.Scanner;

public class P14_Longest_Collatz_Sequence {
	
	private static int limit = 5 * 1000_000;
	private static int[] a = new int[limit + 1];
	// record the maximum index
	private static int[] b = new int[limit + 1];

	public static void main(String[] args) {
		a[1] = 1;
		setArray();
		findMaxIndex();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int a0 = in.nextInt();
			System.out.println(b[a0]);
		}
		in.close();
	}

	/**
	 * 
	 * @param a
	 * @param b
	 */
	private static void findMaxIndex() {
		b[0] = b[1] = 1;
		for (int i = 2; i < a.length; i++) {
			if (a[i] >= a[b[i - 1]]) {
				b[i] = i;
			} else {
				b[i] = b[i - 1];
			}
		}
	}

	/**
	 * set the step of every number that is below 5 * 10^6 ,
	 * 
	 * @param a
	 */
	private static void setArray() {
		int count = 0;
		// i = 2^n
		for (int i = 2; i <= limit; i *= 2) {
			a[i] = ++count;
		}
		// other indexes
		for (int i = 2; i <= limit; i++) {
			countchain(i);
		}
	}

	/**
	 * calculate the steps that it takes to reduce to 1
	 * 
	 * @param n
	 * @param a
	 * @return
	 */
	private static int countchain(int n) {
		int count = 0;
		// store the temporary result
		long tmp = n;
		while (tmp > 1) {
			if (tmp <= limit) {
				int index = (int) tmp;
				if (a[index] > 0) {
					a[n] = a[index] + count;
					return a[n];
				}
			}
			tmp = oneStep(tmp);
			count++;
		}
		// store the result
		a[n] = count;
		return a[n];
	}

	/**
	 * do one step, 
	 * caution: tmp would overflow if using the integer type
	 * 
	 * @param tmp
	 * @return
	 */
	private static long oneStep(long tmp) {
		if (tmp % 2 == 0) {
			tmp /= 2;
		} else {
			tmp *= 3;
			tmp++;
		}
		return tmp;
	}
}
