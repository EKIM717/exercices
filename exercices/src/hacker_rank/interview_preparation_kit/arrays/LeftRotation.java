package hacker_rank.interview_preparation_kit.arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LeftRotation {
	  // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
    	if (d == 0 || d == a.length) {
    		return a;
    	}
    	int[] rightPart = Arrays.copyOfRange(a, d, a.length);
    	if (0 == rightPart.length) {
    		return a;
    	}
    	int[] leftPart = Arrays.copyOfRange(a, 0, d);
    	System.arraycopy(rightPart, 0, a, 0, rightPart.length);

    	System.arraycopy(leftPart, 0, a, rightPart.length, leftPart.length);
//    	int i = 0;
//    	// right part to left part
//    	for (int k = 0; k < rightPart.length; k++) {
//			a[i++] = rightPart[k];
//		}
//		// left part to right part
//		for (int k = 0; k < leftPart.length; k++) {
//			a[i++] = leftPart[k];
//		}
		return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        for (int i = 0; i < a.length; i++) 
        	System.out.print(a[i] + " ");
        int[] result = rotLeft(a, d);
        for (int i = 0; i < result.length; i++) 
        	System.out.print(result[i] + " ");

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
