package hacker_rank.project_euler;

import java.util.Scanner;

public class P18_Maximum_path_sum_I {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        while (t-- > 0) {
	            int a0 = in.nextInt();
	            long[][] arr = new long[a0][a0];
	            for (int i = 0; i < a0; i++) {
	                for (int j = 0; j <= i; j++) {
	                    arr[i][j] = in.nextInt();
	                }
	            }
	            // begin
	            System.out.println(recursion(arr));
	        }
	        in.close();
	    }

	    private static long recursion(long[][] a) {
	        for (int i = a.length - 2; i >= 0; i--) {
	            for (int j = 0; j <= i; j++) {
	                a[i][j] += max(a[i+1][j] , a[i+1][j+1]);
	              
	            }
	        }
	        return a[0][0];
	    }

	    private static long max(long a, long b) {
	        return a > b ? a : b;
	    }
}
