package hacker_rank.project_euler;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P29_from_others {

	static int[] a = new int[100000 + 1];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Set<Double> set = new HashSet<>();
		for (int i = 2; i < n; i++) {
			for (int j = 2; j < n; j++) {
				double d = Math.log(i) * j;
				set.add(d);
			}
		}
		System.out.println(set.size());
	}
}
