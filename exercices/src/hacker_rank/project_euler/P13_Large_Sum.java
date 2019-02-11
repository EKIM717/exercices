package hacker_rank.project_euler;

import java.util.Scanner;

import javax.tools.Diagnostic;

public class P13_Large_Sum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int tenDigit = 10;
		int length = 50 / tenDigit;
		long[][] a = new long[t][length];
		while (t-- > 0) {
			String s = in.next();
			long[] a0 = a[t];
			char[] ch = s.toCharArray();
			int j = 0;
			for (int i = ch.length; i - 10 >= 0; i -= 10) {
				String subStr = s.substring(i - 10, i);
				Long tmp = Long.valueOf(subStr);
				a0[j++] = tmp;
			}
		}
		long digits = 100000_00000L;
		int carried = 0;
		for (int j = 0; j < a[0].length - 1; j++) {
			long tmp = 0;
			for (int i = 0; i < a.length; i++) {
				// System.out.print(a[i][j] + " ");
				tmp += a[i][j];
			}
			// System.out.println("sum is " + tmp + " carried is " + carried);
			tmp += carried;
			carried = (int) (tmp / digits);
		}
		long result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i][a.length - 1];
		}
		// System.out.println("sum is " + result + " carried is " + carried);
		result += carried;
		long digitExceed = (result / digits);
		int tenPow = 1;
		if (digitExceed > 0) {
			do {
				tenPow *= 10;
				digitExceed /= 10L;
			} while (digitExceed > 0L);
		}
		System.out.println(result / tenPow);
	}

}
