package hacker_rank.interview_preparation_kit.arrays;

import java.util.Scanner;

public class NewYearChaos {
	
	static int LIMIT = 2;
	
	static void swap(int i, int j, int[] q) {
		int tmp = q[i];
		q[i] = q[j];
		q[j] = tmp;
	}
	
	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		sort(q);
	}
	
	static void sort(int[] q) {
		int k = q.length;
		boolean tooChaotic = false;
		int max = 0;
		int recordSortedIndex = 0;
		outter: for (int i = 0; i < q.length - 1; i++) {
			boolean isSorted = true;
			int toRightCount = 0;
			for (int j = 0; j < k - 1; j++) {
				if (q[j] > q[j + 1]) {
					swap(j, j + 1, q);
					toRightCount++;
					max++;
					// the latest swap index
					recordSortedIndex = j;
					isSorted = false;
				} else {
					// set to zero
					toRightCount = 0;
				}
				if (toRightCount > LIMIT) {
					tooChaotic = true;
					break outter;
				}
			}
			k = recordSortedIndex + 1;
			if (isSorted) {
				break outter;
			}
		}
		if (tooChaotic) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(max);
		}
	}
	
	/**
	 * 限制每次移位不超过2
	 * @param q
	 * @return
	 */
	static int bubble(int[] q) {
		int k = q.length;
		int j = 0;
		int max = 0;
		boolean tooChaotic = false;
		outter: while (j <= k) {
			boolean toLeftChaotic = false;
			boolean toRightChaotic = false;
			int toRightCount = 0;
			inner1: for (int i = 0; i < k - 1; i++) {
				if (q[i] > q[i + 1]) {
					swap(i, i + 1, q);
					toRightCount++;
					max++;
				} else {
					// set to zero
					toRightCount = 0;
				}
				if (toRightCount > LIMIT) {
					toRightChaotic = true;
					break inner1;
				}
			}
			if (!toRightChaotic) {
				k--;
			}
			//
			int toLeftCount = 0;
			inner2: for (int m = k - 1; m > j; m--) {
				if (q[m] < q[m - 1]) {
					swap(m, m - 1, q);
					toLeftCount++;
					max++;
				} else {
					// set to zero
					toLeftCount = 0;
				}
				if (toLeftCount > LIMIT) {
					toLeftChaotic = true;
					break inner2;
				}
			}
			if (!toLeftChaotic) {
				j++;
			}
			
			if (toLeftChaotic && toRightChaotic) {
				tooChaotic = true;
				break outter;
			}
		}
		if (tooChaotic) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(max);
		}
		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
