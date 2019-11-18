package hacker_rank.interview_preparation_kit.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps2 {

	 // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	return bubbleByOneDirection(arr);

    }
    
    static void swap(int i, int j, int[] q) {
		int tmp = q[i];
		q[i] = q[j];
		q[j] = tmp;
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
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
