package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P7_The10001stPrime {
	
	private static int MAX_INDEX = 10000;
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
//        System.out.println(LocalDateTime.now());
        List<Long> list = primeList();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            //index = n - 1
            System.out.println(list.get(n - 1));
        }
//        System.out.println(LocalDateTime.now());
        in.close();
    }
	
	/**
	 * store the prime list
	 * @return
	 */
	private static List<Long> primeList() {
        List<Long> list = new ArrayList<>();
        list.add(2L);
        int index = 1;
        long prime = 3;
        while (index < MAX_INDEX) {
        	if (judge(prime)) {
        		index++;
        		list.add(prime);
        	}
        	prime += 2;//the prime above 2 cannot be a even number
        }
        return list;
	}
	
	/**
	 * judge a number whether is a prime
	 * @param prime
	 * @return
	 */
	private static boolean judge(long prime) {
    	for (long i = 2; i * i <= prime; i++) {
    		if (prime % i == 0) {
    			return false;
    		}
    	}
    	return true;
	}
}
