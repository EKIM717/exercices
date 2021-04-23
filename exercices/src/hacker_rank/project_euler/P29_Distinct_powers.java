package hacker_rank.project_euler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class P29_Distinct_powers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		Map<Integer, Integer> powerMap = reduceRoot(n);
//		System.out.println("---------------");
//		System.out.println(LocalDateTime.now());
		Long totalCount = 0L;

		// get every power count
		Map<Integer, Long> resultMap = getPowerCount(n);

		for (Integer key : powerMap.keySet()) {
			Integer power = powerMap.get(key);
			totalCount += resultMap.get(power);
		}
//		System.out.println(LocalDateTime.now());
		System.out.println(totalCount);
		in.close();

	}

	/**
	 * reduce root for example: the root of 4 and 8 are both 2
	 * 
	 * @param n
	 * @return
	 */
	private static Map<Integer, Integer> reduceRoot(int n) {
		Set<Integer> duplicateRootSet = new TreeSet<>();
		Map<Integer, Integer> powerMap = new TreeMap<>();
		for (int x = 2; x <= n; x++) {
			if (duplicateRootSet.contains(x)) {
				continue;
			}

			powerMap.put(x, 1);
			duplicateRootSet.add(x);
			for (int b = 2;; b++) {
				double d = Math.pow(x, b);
				if (d <= n) {
					int temp = (int) d;
					if (duplicateRootSet.contains(temp)) {
						continue;
					}
					// restore the number
					duplicateRootSet.add(temp);
					powerMap.put(x, b);
				} else if (b == 2) {
					// only has one power
				} else {
					break;
				}
			}
		}
		return powerMap;
	}

	/**
	 * get every power count
	 * 
	 * @param n
	 * @return
	 */
	static Map<Integer, Long> getPowerCount(int n) {
		// the minimum power is 2
		int k = 2;
		for (;; k++) {
			double d = Math.pow(2, k);
			if (d > (double) n) {
				break;
			}
		}
		// get the max power
		k--;
		// restores every power count
		Map<Integer, Long> map = new HashMap<>();
		for (; k >= 1; k--) {
			int[] bitArray = new int[n * k + 1];
			int temp = k;
			for (int i = 1; i <= temp; i++) {
				for (int j = 2; j <= n; j++) {
					bitArray[i * j] = 1;
				}
			}
//			Arrays.stream(bitArray).forEach(System.out::println);
			Long v = 0L;
			for (Integer i : bitArray) {
				if (i == 1) {
					v++;
				}
			}
			map.put(temp, v);
		}
		return map;
	}
	
}
