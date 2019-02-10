package hacker_rank.project_euler;

import java.util.Scanner;

public class P9_SpecialPythagoreanTriplet {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            
	            System.out.println(getN(n));
	        }
	        in.close();
	}
	
	private static long getN(int n) {
		long max = -1;
		//assume x is the longest line
		for (long x = n / 3 + 1; x < n / 2; x++) {
			//assume y is the second longest line
			for (long y = x - 1; y > 0 && y < x; y--) {
				long z = n - x - y;
				if (z < 1 || z > y)
					continue;
				if (x * x != y * y + z * z)
					continue;
//					System.out.println("n=" + x + "+" + y + "+" + z + ", xyz = " + x * y * z);
				return x * y * z;
			}
		}
		return max;
	}
	
}
