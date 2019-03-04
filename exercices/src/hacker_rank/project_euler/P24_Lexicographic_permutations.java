package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P24_Lexicographic_permutations {

	private static char c = 'm';
	private static int array_length = c - 'a' + 1;
	private static char[] cArray = new char[array_length];

	static {
		int i = 0;
		while (i < array_length) {
			cArray[i++] = c--;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			long l = in.nextLong();
			System.out.println(foo(l - 1));
		}
		in.close();
	}

	/**
	 * In this article, a factorial number representation will be flagged by a
	 * subscript "!", so for instance 341010! stands for 354413021100, whose value
	 * is = 3��5! + 4��4! + 1��3! + 0��2! + 1��1! + 0��0! = ((((3��5 + 4)��4 + 1)��3 + 0)��2 +
	 * 1)��1 + 0 = 463. For example, 46310 can be transformed into a factorial
	 * representation by these successive divisions:
	 * 
	 * 463 �� 1 = 463, remainder 0 
	 * 463 �� 2 = 231, remainder 1 
	 * 231 �� 3 = 77, remainder 0 
	 * 77 �� 4 = 19, remainder 1 
	 * 19 �� 5 = 3, remainder 4 
	 * 3 �� 6 = 0, remainder 3
	 */

	private static String foo(long n) {
		int length = cArray.length;
		long[] a = new long[length];
		List<Character> listToRemove = new ArrayList<>();
		for (int q = length - 1; q >= 0; q--) {
			listToRemove.add(cArray[q]);
		}
		long quotient = 0;
		int i = 1;
		int count = 0;
		while (true) {
			quotient = n / i;
			long remainder = n % i;
			a[i - 1] = remainder;
			count++;
			if (quotient == 0) {
				break;
			}
			n = quotient;
			i++;
		}
		char[] result = new char[length];
		int k = 0;
		//not affected
		for (int ii = length - 1; ii >= count; ii--) {
			result[k++] = listToRemove.remove(0);
		}
		//affected,reverse
		for (int mm = count - 1; mm >= 0; mm--) {
			int nn = (int) a[mm];
			result[k++] = listToRemove.remove(nn);
		}
		return new String(result);
	}
}
