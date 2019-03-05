package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P24_Lexicographic_permutations {

	private static char c = 'm';
	private static int array_length = c - 'a' + 1;
	private static char[] cArray = new char[array_length];

	static {
		char ch = 'a';
		int i = 0;
		while (ch <= c) {
			cArray[i++] = ch++;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			long l = in.nextLong();
			System.out.println(getResult(l - 1));
		}
		in.close();
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	private static String getResult(long n) {
		List<Integer> permutations = getPermutations(n);
		int size = permutations.size();
		char[] result = new char[array_length];
		int k = 0;
		//not affected
		for (int i = 0; i < array_length - size; i++) {
			result[k++] = cArray[i];
		}
		//permutation
		List<Character> listAffected = new ArrayList<>();
		for (int j = array_length - size; j < array_length; j++) {
			listAffected.add(cArray[j]);
		}
		for (int m = size - 1; m >= 0; m--) {
			int index = permutations.get(m);
			result[k++] = listAffected.remove(index);
		}
		return new String(result);
	}
	
	/**
	 * In this article, a factorial number representation will be flagged by a
	 * subscript "!", so for instance 341010! stands for 354413021100, whose value
	 * is = 3¡Á5! + 4¡Á4! + 1¡Á3! + 0¡Á2! + 1¡Á1! + 0¡Á0! = ((((3¡Á5 + 4)¡Á4 + 1)¡Á3 + 0)¡Á2 +
	 * 1)¡Á1 + 0 = 463. For example, 46310 can be transformed into a factorial
	 * representation by these successive divisions:
	 * 
	 * 463 ¡Â 1 = 463, remainder 0 
	 * 463 ¡Â 2 = 231, remainder 1 
	 * 231 ¡Â 3 = 77, remainder 0 
	 * 77 ¡Â 4 = 19, remainder 1 
	 * 19 ¡Â 5 = 3, remainder 4 
	 * 3 ¡Â 6 = 0, remainder 3
	 */
	private static List<Integer> getPermutations(long n) {
		List<Integer> list = new ArrayList<>();
		int i = 1;
		while (true) {
			long quotient = n / i;
			long remainder = n % i;
			list.add((int)remainder);
			if (quotient == 0) {
				break;
			}
			n = quotient;
			i++;
		}
		return list;
	}
}
