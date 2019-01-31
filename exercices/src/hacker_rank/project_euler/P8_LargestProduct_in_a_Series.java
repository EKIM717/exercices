package hacker_rank.project_euler;

import java.util.Scanner;

public class P8_LargestProduct_in_a_Series {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in);) {
			int t = in.nextInt();
			for (int a0 = 0; a0 < t; a0++) {
				int n = in.nextInt();
				int k = in.nextInt();
				String a = in.next();
				char[] charArr = a.toCharArray();
				long max = 0L;
				loop1: for (int i = 0; i <= n - k; i++) {
					long tmp = 1L;
					for (int j = i; j < k + i; j++) {
						char c = charArr[j];
						if (c == '0') {
							continue loop1;
						}
						int value = c - '0';
						tmp *= value;
					}
					if (max < tmp) {
						max = tmp;
					}
				}
				System.out.println(max);
			}
		}
	}
}
