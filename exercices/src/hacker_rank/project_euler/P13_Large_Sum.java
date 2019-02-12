package hacker_rank.project_euler;

import java.util.Scanner;

public class P13_Large_Sum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] c = new int[60];
		for (int i = 0; i < c.length; i++) {
			c[i] = 0;
		}
		while (t-- > 0) {
			// the input string
			String s = in.next();
			char[] ch = s.toCharArray();
			int i = 0;
			int carry = 0;
			// 50 digits sum
			for (int j = ch.length - 1; j >= 0; j--, i++) {
				int sum = c[i] + ch[j] - '0' + carry;
				// next carry
				carry = sum / 10;
				c[i] = sum % 10;
			}
			// extra carry
			while (i < c.length) {
				if (carry == 0) {
					break;
				}
				int sum = c[i] + carry;
				// next carry
				carry = sum / 10;
				c[i++] = sum % 10;
			}
		}
		// output
		int record = 0;
		for (int i = c.length - 1; i >= 0; i--) {
			// find the first index of the number that is not equal to zero,
			// from behind to front
			if (c[i] > 0) {
				record = i;
				break;
			}
		}
		int i = 0;
		StringBuilder sb = new StringBuilder();
		// reverse
		while (record - 9 >= 0 && i < 10) {
			sb.append(c[record - i++]);
		}
		System.out.println(sb.toString());
		in.close();
	}

}
