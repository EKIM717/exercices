package hacker_rank.project_euler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class P29_Distinct_powers {
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int a = in.nextInt();
			System.out.println("------------------------");
			System.out.println(LocalDateTime.now());
			System.out.println(foo(a));
			System.out.println(LocalDateTime.now());
		}
		in.close();
	}

	static long foo(int n) {
		//store the prime
		boolean[] prime_array = new boolean[100001];
		//findPrime
//		System.out.println(LocalDateTime.now());
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				prime_array[i] = true;
			}
		}
//		System.out.println(LocalDateTime.now());
		//repeat
		Set<Integer> repeatSet = new HashSet<>();
		int sum = 0;
		Map<String, Set<String>> powMap = new HashMap<>();
		loopMain: for (int i = 2; i <= n; i++) {
			//if i is a prime
			if (prime_array[i]) {
				int fac = i;
				int count = 1;
				while ((fac *= i) <= n) {
					count++;
				}
				sum += getCount(count, n);
				continue loopMain;
			}
			// Prime factorization, i = m^p * n^q..., the map is {{m: p}, {n, q}...}
			String[] array = divid(i, prime_array);
			//if i = m^p (p>1), the map is {{m: p}}
			if (array[0].split("\\|").length == 1) {
				continue loopMain;
			}
			// if i = m^p * n^q (p>=1, q>=1), the map is {{m: p}, {n, q}}
			for (int j = 2; j <= n; j++) {
				if (i == j) {
					repeatSet.add(i);
					continue;
				}
				StringBuilder valueStr = new StringBuilder();
				for (String k : array[1].split("\\|")) {
					int powNum = Integer.valueOf(k) * j;
					valueStr.append(powNum + "|");
				}
				String key = array[0];
				Set<String> set = powMap.get(key);
				if (null == set) {
					set = new HashSet<>();
					set.add(valueStr.toString());
					powMap.put(key, set);
					sum++;
				} else {
					if (!set.contains(valueStr.toString())) {
						sum++;
						set.add(valueStr.toString());
					}
				}
			}
		}
//		for (String k : powMap.keySet()) {
//			if (null != powMap.get(k)) {
//				for (String j : powMap.get(k))
//					System.out.println(k + "^" + j);
//			}
//		}
		return sum + repeatSet.size();
	}

	static String[] divid(int n, boolean[] prime_array) {
		String[] array = new String[2];
		StringBuilder key = new StringBuilder();
		StringBuilder value = new StringBuilder();
		// divided by 2
		int countOf2 = 0;
		while (n % 2 == 0) {
			n /= 2;
			countOf2++;
		}
		if (countOf2 > 0) {
			key.append(2 + "|");
			value.append(countOf2 + "|");
		}
		if (n == 1) {
			array[0] = key.toString();
			array[1] = value.toString();
			return array;
		}
		for (int i = 3; i <= n; i += 2) {
			if (prime_array[i]) {
				int count = 0;
				while (n % i == 0) {
					n /= i;
					count++;
				}
				if (count > 0) {
					key.append(i + "|");
					value.append(count + "|");
				}
				if (n == 1) {
					array[0] = key.toString();
					array[1] = value.toString();
					return array;
				}
			}
		}
//		if (map.containsValue(0)) {
//			System.out.println();
//		}
		return array;
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
	
	static int getCount(int count, int n) {
		int sourceN = n;
		int total = n - 1;
		for (int i = 2; i <= count; i++) {
			while (n > 1 && i * n > (i -1) * sourceN) {
				n--;
				total++;
			}
		}
		return total;
	}
}
