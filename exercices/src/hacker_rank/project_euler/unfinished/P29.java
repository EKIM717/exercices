package hacker_rank.project_euler.unfinished;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class P29 {

	static int limit = 100000;

	public static void main(String[] args) {
		// store the prime
		boolean[] prime_array = new boolean[100001];
		// findPrime
//		System.out.println("findPrime------------");
//		System.out.println(LocalDateTime.now());
//		int primeCount = 1;
		for (int i = 2; i <= limit; i++) {
			if (isPrime(i)) {
				prime_array[i] = true;
//				primeCount++;
			}
		}
//		System.out.println(LocalDateTime.now());

		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		TreeMap<Integer, Map<Integer, Integer>> totalDivisor = new TreeMap<>();
		for (int i = 2; i <= a; i++) {
			totalDivisor.put(i, primeFactorization(i, prime_array));
		}
//		System.out.println("------------------------");
		System.out.println(LocalDateTime.now());
		System.out.println(foo(a, prime_array, totalDivisor));
		System.out.println(LocalDateTime.now());
		in.close();
	}

	/**
	 * 
	 * @param n
	 * @param prime_array
	 * @return
	 */
	static TreeMap<Integer, Integer> primeFactorization(int n, boolean[] prime_array) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		if (prime_array[n]) {
			map.put(n, 1);
			return map;
		}
		// divided by 2
		int countOf2 = 0;
		while (n % 2 == 0) {
			n /= 2;
			countOf2++;
		}
		if (countOf2 > 0) {
			map.put(2, countOf2);
		}
		if (n == 1) {
			return map;
		}
		for (int i = 3; i <= n; i += 2) {
			if (prime_array[i]) {
				int count = 0;
				while (n % i == 0) {
					n /= i;
					count++;
				}
				if (count > 0) {
					map.put(i, count);
				}
				if (n == 1) {
					return map;
				}
			}
		}
		return map;
	}

	private static int foo(int n, boolean[] prime_array, TreeMap<Integer, Map<Integer, Integer>> totalDivisor) {
		Map<String, TreeSet<String>> powMap = new HashMap<>();
		int sum = 0;
		for (int i = 2; i <= n; i++) {
			// if i = m^p * n^q, the map is {{m: p}, {n, q}}
			if (i == 15 * 15) {
				System.out.println();
			}
			Map<Integer, Integer> map = totalDivisor.get(i);
//	            if (null != map.get(i) && map.get(i) == 1) {// if i is a prime
//	                sum += n - 1;
//	                Set<Integer> set = new HashSet<>();
//	                for (int j = 2; j <= n; j++) {
//	                    set.add(j);
//	                }
////	                powMap.put(i, set);
//	            } else {
//			int kkk = 1;
			StringBuilder valueStr = new StringBuilder();
	        StringBuilder keyStr = new StringBuilder();
			for (Integer k : map.keySet()) {
//				kkk *= k;
				keyStr.append(k + "*");
//		            	int powNum = map.get(k) * j;
				valueStr.append(map.get(k) + " ");
			}
			keyStr.deleteCharAt(keyStr.length() - 1);
			if (null == powMap.get(keyStr.toString())) {
				TreeSet<String> set = new TreeSet<>();
				set.add(valueStr.toString());
				powMap.put(keyStr.toString(), set);
			} else {
				powMap.get(keyStr.toString()).add(valueStr.toString());
			}
//	                for (int j = 2; j <= n; j++) {
////	                	totalDivisor.get(j);
////	                    String key = keyStr.toString();
//	                    if (!set.contains(valueStr.toString())) {
////	                        sum++;
////	                        set.add(valueStr.toString());
//	                    }
//	                }
//	            }
		}
		//calc
		int countOne = 0;
		Set<String> uniqueMultiple = new HashSet<>();
		for (String k : powMap.keySet()) {
			if (powMap.get(k).size() == 1) {//only have one multiple below 100000,so add N - 1
				uniqueMultiple.add(k);
				countOne++;
				System.out.println(k + "  " +  powMap.get(k));
				sum += n - 1;
			}
		}
		System.out.println("only have one multiple   " + countOne);
		System.out.println(powMap.keySet().size());
		System.out.println("after remove");
		powMap.keySet().removeAll(uniqueMultiple);
		System.out.println(powMap.keySet().size());
		for (String k : powMap.keySet()) {
				System.out.println(k + "  " +  powMap.get(k));
		}
//			if (null != powMap.get(k)) {
//				for (String j : powMap.get(k))
//					System.out.println(k + "^" + j);
//			}
		return sum;
	}

	static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		} else if (n == 2) {
			return true;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
