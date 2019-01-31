package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P4_LargestPalindromeProduct {
	
	//The smallest 6 digit palindrome made from the product of two 3-digit numbers is 101101 = 143 * 707
	private static int LEFT_BOUNDARY = 101101;
	public static void main(String[] args) {
		//a list of palindromic numbers
		//that made from the product of two 3-digit numbers
		List<Integer> list = getPalindromicNumberList();
		try (Scanner in = new Scanner(System.in);) {
			int t = in.nextInt();
			loop1: for (int a0 = 0; a0 < t; a0++) {
				int n = in.nextInt();
				//If N is a palindrome, N can't be the answer.
				int N = n - 1;
				while (N >= list.get(0)) {
					for (int i = 0; i < list.size(); i++) {
						int v = list.get(i);
						if (v == N) {
							System.out.println(N);
							continue loop1;
						}
					}
					N--;
				}
				System.out.println(LEFT_BOUNDARY);
			}
		}
	}
	
	private static boolean productOfTwo3digitNnumbers(int n) {
		for (int i = 100; i < 1000; i++) {
			int quotient = n / i;
			int remain = n % i;
			if (quotient > 100 && quotient < 1000 && remain == 0)
				return true;
		}
		return false;
	}
	
	private static List<Integer> getPalindromicNumberList() {
		List<Integer> list = new ArrayList<>();
		for (int i = 101102; i < 1000_000; i++) {
			if (isPalindrome(i) && productOfTwo3digitNnumbers(i)) {
				list.add(i);
			}
		}
		return list;
	}
	
	/**
	 * judge whether is a palindromic number
	 * @param n
	 * @return
	 */
	private static boolean isPalindrome(int n) {
		String s = String.valueOf(n);
		char[] charArr = s.toCharArray();
		for (int i = 0, j = charArr.length - 1; i < j; i++, j--) {
			if (charArr[i] != charArr[j]) {
				return false;
			}
		}
		return true;
	}
}
