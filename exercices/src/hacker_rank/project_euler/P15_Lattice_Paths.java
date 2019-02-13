package hacker_rank.project_euler;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class P15_Lattice_Paths {

	static BigInteger MODE = BigInteger.valueOf((long) (Math.pow(10, 9) + 7));

	static int limit = 500;

	static BigInteger[][] a = new BigInteger[limit][limit];

	public static void main(String[] args) {
		init();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int m = in.nextInt();
			int n = in.nextInt();
			// always let m be above n,
			// as we know, the situation of m * n and n * m
			// are both (m+n)! / (m! * n!)
			if (m < n) {
				int temp = m;
				m = n;
				n = temp;
			}
			m -= 1;
			n -= 1;
			System.out.println(a[m][n].mod(MODE));
		}
		if (null != in) {
			in.close();
		}
	}

	/**
	 * using memorization caching
	 * put all the result into array
	 */
	private static void init() {
		for (int i = 0; i < limit; i++) {
			a[i][0] = BigInteger.valueOf(i + 2);
		}
		for (int i = 0; i < limit; i++) {
			for (int j = 0; j <= i; j++) {
				a[i][j] = foo(i, j);
			}
		}
	}

	private static BigInteger foo(int m, int n) {
		// always let m be above n
		if (m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		if (Objects.equals(a[m][n], null)) {
			return foo(m - 1, n).add(foo(m, n - 1));
		}
		return a[m][n];
	}
}
