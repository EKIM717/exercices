package hacker_rank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		int count = 0;
		boolean below = false;
		int altitude = 0;
		for (char c : s.toCharArray()) {
			if (c == 'U') {
				altitude++;
			} else if (c == 'D') {
				altitude--;
			} else {
				continue;
			}
			boolean statusBefore = below;
			if (altitude < 0)
				below = true;
			else
				below = false;

			if (true == statusBefore && false == below)
				count++;
		}
		return count;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		File f = new File("F:\\t1.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
