package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3_LargestPrimeFactor {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in);) {
			int t = in.nextInt();
			List<Long> list = new ArrayList<>();
			for (int a0 = 0; a0 < t; a0++) {
				long n = in.nextLong();
				long i = 2;
				// System.out.println(LocalDateTime.now());
				loopStep1: while (true) {
					if (n % i != 0)
						break loopStep1;
					// repeatedly divide by 2
					n = n / i;
				}
				if (n == 1) {
					list.add(i);
					continue;
				} else {// the rest is a odd number
					i = 3;
					long sqrt = (long) Math.sqrt(n);
					// the max factor
					long max = i;
					for (; i <= sqrt;) {
						if (n % i == 0) {
							n = n / i;
							max = i;
						} else {
							// plus 2, because all the rest factors cannot be
							// even number
							i += 2;
						}
					}
					if (n == 1) {// N is divisible by i
						list.add(max);
					} else {// N is a prime
						list.add(n);
					}
				}

				// System.out.println(maxFactor);
				// System.out.println(LocalDateTime.now());
				// list.add(maxFactor);
			}
			for (Long l : list) {
				System.out.println(l);
			}
		}
	}

}
