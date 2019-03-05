package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P24_Lexicographic_permutations {

	private static char last_character = 'm';
	private static char first_character = 'a';
	private static int array_length = last_character - first_character + 1;
	private static char[] cArray = new char[array_length];

	static {
		int i = 0;
		while (first_character <= last_character) {
			cArray[i++] = first_character++;
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
		List<Character> l = new ArrayList<>();
		for (Character c : cArray) {
			l.add(c);
		}
		int[] permutations = getPermutations(n);
		int k = 0;
		char[] result = new char[array_length];
		for (int i = array_length - 1; i >= 0; i--) {
			Character cc = l.remove(permutations[i]);
			result[k++] = cc;
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
	private static int[] getPermutations(long n) {
		int[] p = new int[array_length];
		int i = 1;
		int index = 0;
		while (true) {
			long quotient = n / i;
			long remainder = n % i;
			p[index++] = (int) remainder;
			if (quotient == 0) {
				break;
			}
			n = quotient;
			i++;
		}
		return p;
	}
}
