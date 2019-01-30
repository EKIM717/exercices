package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P6_SumSquareDifference {
	
	private static int MAX_INDEX = 10000;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		//store the result
		List<Long> list = getResultList();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(list.get(n - 1));
		}
		in.close();
	}
	
	/**
	 * is a combination of 1 to n
	 * such as : a b c, then the sum = 2 * (ab + ac + ad + bc + bd + cd)
	 * @param n
	 * @return
	 */
	private static long getSquareDifference(long n) {
		//is a combination of 1 to n
		// the form is like
		//sum = 2 * (ab + ac + ad + bc + bd + cd)
		long sum = 0;
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				sum += i * j;
			}
		}
		return 2 * sum;
	}
	
	/**
	 * use last result to sum
	 * such as: the last result is combination of a b c, and the last sum is sumOfLast
	 * the next number is d
	 * then the next sum = sumOfLast + 2 (ad + bd + cd)
	 * @param lastResult
	 * @param n
	 * @return
	 */
	private static long useLastResult(long lastResult, int n) {
		long count = (1 + n) * n / 2;
		return 2 * count * (n + 1) + lastResult;
	}
	
	private static List<Long> getResultList() {
		List<Long> list = new ArrayList<>();
		list.add(0L);
		list.add(getSquareDifference(2));
		for (int i = 2; i < MAX_INDEX; i++) {
			long current = useLastResult(list.get(i - 1), i);
			list.add(current);
		}
		return list;
	}
	
}
