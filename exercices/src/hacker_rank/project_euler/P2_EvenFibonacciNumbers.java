package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2_EvenFibonacciNumbers {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in);) {
			long n = in.nextLong();
			// store the last result
			long recordLastNum = 0;
			long recordLastSum = 0;
			long lastAn0 = 1;
			long lastAn1 = 1;
			// store the sum of even Fibonacci numbers
			List<Long> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				long num = in.nextLong();
				// temp result
				long next = 0;
				long An0 = 1;
				long An1 = 1;
				long sum = 0;
				// if the number you give is above the last number,
				// then we can use the last result to continue the calculation
				if (num > recordLastNum) {
					An0 = lastAn0;
					An1 = lastAn1;
					sum = recordLastSum;
				}
				while (true) {
					// next number
					next = An0 + An1;
					if (next > num) {
						break;
					}
					if (next % 2 == 0) {
						sum += next;
						recordLastSum = sum;
					}
					// swap the number
					long tmp = An1;
					An1 = next;
					An0 = tmp;
					// record last result
					lastAn0 = An0;
					lastAn1 = An1;
					recordLastNum = next;

				}
				list.add(sum);
			}
			for (long r : list) {
				System.out.println(r);
			}
		}
	}
}
