package hacker_rank.interview_preparation_kit.arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ayyay2D_DS {


	    // Complete the hourglassSum function below.
	    static int hourglassSum(int[][] arr) {
	    	int max = Integer.MIN_VALUE;
	    	// column index
	    	for (int j = 0; j < arr.length - 2; j ++) {
	    		// row index
	    		for (int i = 0; i < arr[0].length - 2; i++) {
	    			int sum = 0;
	    			// first row
	    			for (int y = 0; y < 3; y++) {
	    				sum += arr[i][j + y];
	    			}
	    			// second row
	    			sum += arr[i + 1][j + 1];
	    			// third row
	    			for (int y = 0; y < 3; y++) {
	    				sum += arr[i + 2][j + y];
	    			}
	    			if (max < sum) {
	    				max = sum;
	    			}
	    		}
	    	}
	    	
			return max;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("F:\\OutputFile\\1.txt"));
	        

	        int[][] arr = new int[6][6];

	        for (int i = 0; i < 6; i++) {
	            String[] arrRowItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int j = 0; j < 6; j++) {
	                int arrItem = Integer.parseInt(arrRowItems[j]);
	                arr[i][j] = arrItem;
	            }
	        }

	        int result = hourglassSum(arr);

//	        bufferedWriter.write(String.valueOf(result));
//	        bufferedWriter.newLine();
//
//	        bufferedWriter.close();
	        System.out.println(result);
	        scanner.close();
	    }

}
