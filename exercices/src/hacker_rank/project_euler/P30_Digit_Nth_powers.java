package hacker_rank.project_euler;

import java.util.Scanner;

public class P30_Digit_Nth_powers {
	
	private static int upper_limit = 600000;

	public static void main(String[] args) {
//		int[] xxx = new int[7];
//		for (int i = 3; i <= 6; i++) {
//			for (int x = 2; ;x++) {
//				if ((x * Math.pow(10, i-1) - i * Math.pow(9, i)) > 0) {
//					xxx[i] = (int) (x * Math.pow(10, i-1));
//					System.out.println(xxx[i]);
//					break;
//				}
//			}
//			System.out.println(foo(i, xxx));
//		}
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		System.out.println(foo(i));
		in.close();
	}

	private static int foo(int i) {
		int sum = 0;
		int[] arr = new int[10];
		for (int n = 0; n < 10; n++) {
			arr[n] = (int) Math.pow(n, i);
		}
		for (int j = 2; j < upper_limit; j++) {
			if (j == bar(j, i, arr)) {
//				System.out.print(j + " ");
				sum += j;
			}
		}
		return sum;
	}

	private static int bar(int j, int i, int[] arr) {
		int sum = 0;
		while (j > 0) {
			int remainder = j % 10;
			int r = arr[remainder];
			sum += r;
			j /= 10;
		}
		return sum;
	}
	
	
}
