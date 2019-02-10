package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P10_Summation_of_Primes {

	private static int MAX_INT = 1000_000;

	public static void main(String[] args) {
		List<Long> l = primeList();
		try (Scanner in = new Scanner(System.in);) {
			int t = in.nextInt();
			for (int a0 = 0; a0 < t; a0++) {
				int n = in.nextInt();
				System.out.println(l.get(n - 1));
			}
		}
	}

	private static List<Long> primeList() {
		List<Long> list = new ArrayList<>();
		list.add(0L);
		list.add(0L);
		Long lastPrimeSum = 2L;
		for (int i = 2; i < MAX_INT; i++) {
			int n = i + 1;
			if (isPrime(n)) {
				lastPrimeSum += n;
			}
			list.add(lastPrimeSum);
		}
		return list;
	}

	private static boolean isPrime(long prime) {
		for (int i = 2; i * i <= prime; i++) {
			if (prime % i == 0) {
				return false;
			}
		}
		return true;
	}
}
