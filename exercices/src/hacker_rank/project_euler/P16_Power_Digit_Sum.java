package hacker_rank.project_euler;

import java.math.BigInteger;
import java.util.Scanner;

public class P16_Power_Digit_Sum {

	static long[] sumArray = new long[10001];
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int a0 = in.nextInt();
			long a = foo(a0);
			System.out.println(a);
		}
		in.close();
	}

	private static long foo(int a0) {
		if (sumArray[a0] > 0) {
			return sumArray[a0];
		}
		BigInteger a = new BigInteger("1");
		BigInteger ten = new BigInteger("10");
		BigInteger two = new BigInteger("2");
		for (int i = 1; i <=a0; i++) {
			a = a.multiply(two);
		}
		long sum = 0;
		BigInteger[] quotientAndRemainder = null;
		while (true) {
			quotientAndRemainder = a.divideAndRemainder(ten);
			sum += quotientAndRemainder[1].longValue();
			if (quotientAndRemainder[0].equals(BigInteger.ZERO)) {
				break;
			} else {
				a = quotientAndRemainder[0];
			}
		}
		sumArray[a0] = sum;
		return sum;
	}
}
