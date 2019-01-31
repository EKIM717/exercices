package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P10_Summation_of_Primes {
	
	
	private static int MAX_INT = 1000_000;

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in);) {
			int t = in.nextInt();
			for (int a0 = 0; a0 < t; a0++) {
				int n = in.nextInt();
			}
		}
	}
	
	private static List<Integer> primeList() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        Integer prime = 3;
        //prime cannot be above MAX_INT
        while (prime <= MAX_INT) {
            if (judge(prime)) {
                list.add(prime);
            }
            prime += 2;//the prime above 2 cannot be a even number
        }
        return list;
    }
    
    private static boolean judge(long prime) {
        for (int i = 2; i * i <= prime; i++) {
            if (prime % i == 0) {
                return false;
            }
        }
        return true;
    }
}
