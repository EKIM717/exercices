package hacker_rank.project_euler;

public class P29_backup {
	 static long foo(int n) {
	        int sum = 0;
	        Map<String, Set<String>> powMap = new HashMap<>();
	        for (int i = 2; i <= n; i++) {
	            // if i = m^p * n^q, the map is {{m: p}, {n, q}}
	            Map<Integer, Integer> map = divid(i);
//	            if (null != map.get(i) && map.get(i) == 1) {// if i is a prime
//	                sum += n - 1;
//	                Set<Integer> set = new HashSet<>();
//	                for (int j = 2; j <= n; j++) {
//	                    set.add(j);
//	                }
////	                powMap.put(i, set);
//	            } else {
	                for (int j = 2; j <= n; j++) {
	                    StringBuilder keyStr = new StringBuilder();
	                    StringBuilder valueStr = new StringBuilder();
	                    for (Integer k : map.keySet()) {
	                        keyStr.append(k + "|");
	                        int powNum = map.get(k) * j;
	                        valueStr.append(powNum + "|");
	                    }
	                    String key = keyStr.toString();
	                    Set<String> set = powMap.get(key);
	                    if (null == set) {
	                        set = new HashSet<>();
	                    }
	                    if (!set.contains(valueStr.toString())) {
	                        sum++;
	                        set.add(valueStr.toString());
	                    }
	                    powMap.put(key, set);
	                }
//	            }
	        }
//	        for (String k : powMap.keySet()) {
//	            if (null != powMap.get(k)) {
//	                for (String j : powMap.get(k))
//	                    System.out.println(k + "^" + j);
//	            }
//	        }
	        return sum;
	    }

	    static Map<Integer, Integer> divid(int n) {
	        TreeMap<Integer, Integer> map = new TreeMap<>();
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
	            if (isPrime(i)) {
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
//	        if (map.containsValue(0)) {
//	            System.out.println();
//	        }
	        return map;
	    }

	    static boolean isPrime(int n) {
	        if (n < 2) {
	            return false;
	        } else if (n == 2) {
	            return true;
	        }
	        for (int i = 3; i * i <= n; i++) {
	            if (n % i == 0)
	                return false;
	        }
	        return true;
	    }
}
