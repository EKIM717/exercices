package hacker_rank.project_euler;

import java.util.Scanner;

public class P27_Quadratic_primes {

	//store the primes under 10000
	static boolean[] prime_array = new boolean[10000];

	static {
		for (int i = 2; i < 10000; i++) {
			if (isPrime(i)) {
				prime_array[i] = true;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a0 = in.nextInt();
		int maxNumOfPrimes = 0;
		int resultA = 0;
		int resultB = 0;
		for (int a = -a0; a <= a0; a++) {
			for (int b = -a0; b <= a0; b++) {
				int count = 0;
				mainLoop: for (int n = 0;; n++) {
					long r = n * n + a * n + b;
					if (r < 0) {
						break mainLoop;
					}
					boolean re;
					if (r <= prime_array.length) {
						re = prime_array[(int) r];
					} else {
						re = isPrime(r);
					}
					if (!re) {
						break mainLoop;
					}
					count++;
				}
				if (count > maxNumOfPrimes) {
					maxNumOfPrimes = count;
					resultA = a;
					resultB = b;
//						System.out.println("a= " + a + " b= " + b + " max = " + max);
				}
			}
		}
		System.out.println(resultA + " " + resultB);
//			System.out.println("-----------finished--------");
		in.close();
	}

	private static boolean isPrime(long r) {
		if (r < 2) {
			return false;
		}
		for (int i = 2; i * i <= r; i++) {
			if (r % i == 0) {
				return false;
			}
		}
		return true;
	}
}
