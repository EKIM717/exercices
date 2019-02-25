package hacker_rank.project_euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P22_Names_scores {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] sum = new long[t];
		List<String> list = new ArrayList<>();
		while (t-- > 0) {
			String s = in.next().toUpperCase();
			list.add(s);
		}
		//naturalOrder
		Collections.sort(list, Comparator.naturalOrder());
		int t1 = in.nextInt();
		while (t1-- > 0) {
			String s1 = in.next().toUpperCase();
			lookUp: for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(s1)) {
					if (sum[i] > 0) {
						System.out.println(sum[i]);
						break lookUp;
					}
					long total = 0L;
					for (char c : s1.toCharArray()) {
						total += 1L + c - 'A';
					}
					sum[i] = total * (i + 1);
					System.out.println(sum[i]);
					break lookUp;
				}
			}
		}
		in.close();
	}

}
