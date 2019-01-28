package hacker_rank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JumpingOnTheClouds {
	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int length = c.length;
		if (length <= 2)
			return 1;

		int result = 0;
		List<Integer> l = new ArrayList<>();
		int index = 0;
		for (index = 2; index < length - 1;) {
			if (c[index] == 1) {//if this position is one
				index--;//step back one
			}
			l.add(index);
			index += 2;
			result++;
		}
		//if last jump is over the last step
		if (index >= length) {
			result++;
		}
		for (Integer i : l) {
			System.out.print(i + " ");
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		File f = new File("F:\\t1.txt");
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
//
//		int n = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		int[] c = new int[n];
//
//		String[] cItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			int cItem = Integer.parseInt(cItems[i]);
//			c[i] = cItem;
//		}
//
//		int result = jumpingOnClouds(c);
//		System.out.println(result);
//
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
//
//		scanner.close();
		String s = "0 1 0 1 0 1 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 1 0 1 0 0 1 0 0 0 1 0 1 0 0 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0 0 0 1 0 1 0 1 0 0 1 0 1 0 1 0 0 1 0 0 0 0 1 0 0 1 0 0 0 1 0 0 1 0 1 0";
//		String s = "0 0 1 0 0 1 0";
//		String s = "0 0 0 1 0 0";
		String[] arr = s.split(" ");
		int[] ia = new int[arr.length];
		for (int i = 0; i < ia.length; i++) {
			ia[i] = Integer.valueOf(arr[i]);
		}
		System.out.println(jumpingOnClouds(ia));
	}
}
