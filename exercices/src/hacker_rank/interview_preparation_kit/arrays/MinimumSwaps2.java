package hacker_rank.interview_preparation_kit.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps2 {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int count = 0;
		outter: for (int m = 0; m < arr.length - 1; m++) {
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
			int indexStart = 0;
			int left = arr[indexStart];
			int right = 0;
			inner2: for (int k = indexStart + 1; k < arr.length; k++) {
				right = arr[k];
				if (indexStart == k - 1) {
					continue;
				}
				if (arr[k] < arr[k - 1]) {
					if (arr[indexStart] > arr[k]) {
						
					}
				} else {
					if (k == arr.length - 1) {
						
					}
				}
				if (left <= right) {
					continue;
				}
				if (left > right) {
					// see if there are greater numbers
					if (k < arr.length - 1) {
						if (arr[k + 1] <= arr[k + 2]) {
							if (k < arr.length - 3) {
								indexStart++;
								continue inner2;
							} else {
								count++;
								swap(k, k+1, arr);
								continue outter;
							}
						} else {
							count++;
							swap(indexStart, k+2, arr);
							continue outter;
						}
					} else {
						swap(k, k + 1, arr);
						count++;
						break outter;
					}
				}
			}
			indexStart++;
		}
		return count;

	}

	static void swap(int i, int j, int[] arr) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
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

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = minimumSwaps(arr);

//		bufferedWriter.write(String.valueOf(res));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
