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
		for (int i = 0; i < q.length; i++) {
			if ((q[i] - (i + 1)) > LIMIT) {
				System.out.println("Too chaotic");
				return;
			}
		}
		bubbleByOneDirection(q);
//		bubbleByTwoDirection(q);
	}

	static int bubbleByOneDirection(int[] q) {
		int k = q.length;
		int max = 0;
		int recordSortedIndex = 0;
		outter: for (int i = 0; i < q.length - 1; i++) {
			boolean isSorted = true;
			for (int j = 0; j < k - 1; j++) {
				if (q[j] > q[j + 1]) {
					swap(j, j + 1, q);
					max++;
					// the latest swap index
					recordSortedIndex = j;
					isSorted = false;
				}
			}
			k = recordSortedIndex + 1;
			if (isSorted) {
				break outter;
			}
		}
		System.out.println(max);
		return max;
	}

	static int bubbleByTwoDirection(int[] q) {
		int k = q.length;
		int j = 0;
		int count = 0;
		// sorted index
		int rightEndIndex = 0;
		int leftStartIndex = 0;
		outter: while (j < k) {
			int i = leftStartIndex;
			boolean isSorted = true;
			inner1: for (; i < k - 1; i++) {
				if (q[i] > q[i + 1]) {
					swap(i, i + 1, q);
					rightEndIndex = i;
					count++;
					isSorted = false;
				}
			}
			if (isSorted) {
				break outter;
			}
			k = rightEndIndex;
			//
			j = leftStartIndex;
			inner2: for (int m = k; m > j; m--) {
				if (q[m] < q[m - 1]) {
					swap(m, m - 1, q);
					leftStartIndex = m;
					count++;
					isSorted = false;
				}
			}
			if (isSorted) {
				break outter;
			}
			j = leftStartIndex;
		}
//		for (int x : q) {
//			System.out.print(x + " ");
//		}
		System.out.println(count);
		return count;
	}

	/**
	 * 限制每次移位不超过2
	 * 
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
