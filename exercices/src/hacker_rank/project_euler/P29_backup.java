package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class P29_backup {
	
	public static void main(String[] args) {
		int n = 6;
		Set<Integer> set = new TreeSet<>();
		for (int x = 2; x <= n; x++) {
			for (int b = 2; b <= n; b++) {
				set.add((int) Math.pow(x, b));
			}
		}
		System.out.println(set);
		System.out.println(set.size());
		List<Integer> primeList = findPrimeList(n);
		System.out.println(primeList);
		LinkedHashMap<Integer, Integer> map = divid(n, primeList);
		
		int total = 0;
		for (int index = 0; index < primeList.size(); index++) {
			int tempIndex = index;
			int i = primeList.get(index);
			int powNum = map.get(i);
			System.out.println(i + "-->" + map.get(i));
			int count = 0;
			for (int j = 2; j <= powNum + 1; j++) {
				int q = (int) Math.pow(i, j);
				if (n / q == 0) {
					count++;
				} else {
					++tempIndex;
				}
			}
			total += map.get(i);
		}
		System.out.println(total + "----------");
//		foo(n, map);
	}
	
	private static int calc(int index, int pow, List<Integer> primeList, Map<Integer, Integer> map, int n) {
		int i = primeList.get(index);
		int powNum = map.get(i);
		System.out.println(i + "-->" + map.get(i));
		int count = 0;
		for (int j = 2; j <= powNum + 1; j++) {
			int q = (int) Math.pow(i, j);
			if (n / q == 0) {
				return 1;
			} else {
				++index;
				calc(index, primeList, map, n);
			}
		}
		return count;
	}

	private static List<Integer> findPrimeList(int n) {
		List<Integer> result = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				result.add(i);
			}
		}
		return result;
	}

	static long foo(int n, Map<Integer, Integer> map) {
		long result = 0L;
		n *= n;
		int [] a = new int[1];
		
		for (Integer x : map.keySet()) {
			a[0] = 0;
			Integer q = map.get(x);
			for (int m = 1; m <= q; m++) {
				n /= (int) Math.pow(x, m);
				if (n == 0) {
					result++;
					continue;
				}
				
				long tempResult = 1;
				for (Integer i : map.keySet()) {
					if (i > x) {
						a[0] = 0;
						n = divide(n, i, map, a);
						int temp = a[0];
						if (temp > 0) {
							tempResult *= temp;
						}
						if (0 == n) {
							break;
						}
					}
				}
				
				result += tempResult;
			
			}
			n = divide(n, x, map, a);
			
		}
		return result;
	}
	
	static int divide(int n, int i, Map<Integer, Integer> map, int[] a) {
		Integer q = map.get(i);
		for (int m = 1; m <= q; m++) {
			n /= (int) Math.pow(i, m);
			a[0]++;
			if (n == 0) {
				return n;
			}
		}
		
		return n;
	}

	static LinkedHashMap<Integer, Integer> divid(long n, List<Integer> primeList) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		for (int i : primeList) {
			long temp = n;
			int count = 0;
			if (isPrime(i)) {
				while ((temp /= i) > 0) {
					count++;
				}
//				count *= n;
				map.put(i, count);
			}
		}
		return map;
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
