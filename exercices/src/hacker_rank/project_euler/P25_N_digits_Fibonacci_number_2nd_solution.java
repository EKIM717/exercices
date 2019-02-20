package hacker_rank.project_euler;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * use the Binet's Formula
 * 
 * @author Administrator
 *
 */
public class P25_N_digits_Fibonacci_number_2nd_solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int bjp = 0; bjp < t; bjp++) {
			int n = s.nextInt();
			int i = 0, g = 1;
			while (g != n) {
				g = fact(i);
				i++;
			}
			System.out.println(i - 1);
		}
		s.close();
	}

	static int fact(int n) {
		double d = (n * Math.log10(1.6180339887498948)) - ((Math.log10(5)) / 2);

		return (int) Math.ceil(d);
	}
}
