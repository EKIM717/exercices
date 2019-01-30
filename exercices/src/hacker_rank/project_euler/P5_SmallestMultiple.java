package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 找出1到N这些数的最小公倍数
 * @author Administrator
 *
 */
public class P5_SmallestMultiple {
	
	private static int MAX_INT = 40;

	public static void main(String[] args) {
		//get the prime list
		List<Integer> list = primeList();
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			for (int a0 = 0; a0 < t; a0++) {
				int n = in.nextInt();
				//key - the prime factor, value - the pow of the prime 
				Map<Integer, Integer> map = new HashMap<>();
				for (int index = 2; index <= n; index++) {
					int j = 0;
					for (; ; j++) {
						int current = list.get(j);
						if (current > index) {
							break;
						}
						if (index % current == 0) {
							int pow = 1;
							updateMap(map, current, pow);
							for (pow = 2; Math.pow(current, pow) <= index; pow++) {
								updateMap(map, current, pow);
							}
						}
					}
				}
				long result = 1L;
				for (Integer p : map.keySet()) {
					result *= Math.pow(p, map.get(p));
				}
				System.out.println(result);
			}
		}
	}
	
	private static void updateMap(Map<Integer, Integer> map, int j, int pow) {
		if (map.containsKey(j)) {
			int source = map.get(j);
			if (pow > source) {
				map.put(j, pow);
			}
		} else {
			map.put(j, pow);
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
	
//	
//	private static int judgePrime(int n) {
//		int sqrt = (int) Math.sqrt(n);
//		for (int i = 2; i <= sqrt; i++) {
//			if (n % i == 0)
//				return -1;
//		}
//		return n;
//	}
}
