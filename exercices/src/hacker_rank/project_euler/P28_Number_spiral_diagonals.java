package hacker_rank.project_euler;

import java.math.BigInteger;
import java.util.Scanner;

public class P28_Number_spiral_diagonals {
	
	private static int COLUMN = 1000_000_00 * 8;
	private static int ROW = 1000_000_00 * 8;
	
	private static int num = 1000_000_000 + 7;
	private static BigInteger mod_num = new BigInteger(1000_000_000 + 7 + "");
	private static long[][] result = new long[ROW][COLUMN];
	
	static {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				result[i][j] = -1;
			}
		}
		result[0][0] = 1;
	}
	
	private static long LAST_INDEX = 1;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			long N = in.nextLong();
			long tmp = (N - 1) / 2;
			if (tmp >= LAST_INDEX) {
				calc(N);
			}
			LAST_INDEX = tmp;
			int[] a = getIndex(tmp);
			System.out.println(result[a[0]][a[1]]);
		}
	}
	
	
	private static int[] getIndex(long n) {
		int[] a = new int[2];
		int i = 0;
		while (n > COLUMN) {
			i++;
			n -= COLUMN;
		}
		a[0] = i;
		a[1] = (int) (n-1);
		return a;
	}

	private static void calc(long a) {
		for (long i = 2 * LAST_INDEX + 1; i < a; ) {
			int[] arr = getIndex(i);
			i += 2;
			arr = getIndex(i);
			result[arr[0]][arr[1]] = (int) k;
		}
	}
	
	private static int formula(long n) {
		BigInteger source = new BigInteger(n + "");
		BigInteger minus = new BigInteger(n - 1 + "");
		BigInteger four = new BigInteger("4");
		BigInteger six = new BigInteger("6");
		BigInteger result = source.multiply(source).multiply(four);
		minus = minus.multiply(six).negate();
		result = result.add(minus).mod(mod_num);
		n = n*(n+1)*(2*n+1)/6;
		return result.intValue();
	}
	
	private static void bar(long n) {
		/*
		d1 = (2n + 1) ^2 Hence d1 = 4n^2 + 4n + 1
		The numbers along the other diagonals are simply derived from d1 by subtracting certain values.
		d2 = d1 - 2n Hence d2 = 4n^2 + 2n + 1
		d3 = d2 - 2n Hence d3 = 4n^2 + 1
		d4 = d3 - 2n Hence d4 = 4n^2 - 2n + 1
		Now, all that the problem asks us to do is to sum up the numbers d1, d2, d3, d4 for n = 1, 2, 3, . . . . .. . ..
		sum = summation of (16n^2 + 4n + 4) for n = 1, 2, 3, . . . . .
		Now sum up remaining things like
		16 * summation of n^2 = 8 * n * (n+1) * (2 * n + 1) / 3
		4 * summation of n = 2 * (n) * (n+1)
		summation of 4 = 4 * n
		*/
		long a = (long) (8 * Math.pow(n, 3) / 3+ 30 * Math.pow(n, 2) + 34 * n + 3);
	}
}
