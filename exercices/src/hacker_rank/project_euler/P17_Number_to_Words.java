package hacker_rank.project_euler;

import java.util.Scanner;

public class P17_Number_to_Words {

	static String[] below10 = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	static String[] tenTimesBelow100 = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };
	static String[] thousandTimes = { "", "Thousand", "Million", "Billion" };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			StringBuilder a0 = new StringBuilder(in.next());
			int length = a0.length();
			int times = length / 3;
			int extra = length % 3;
			int zeroBit = 0;
			if (extra > 0) {
				times++;
				zeroBit = 3 - extra;
				for (int i = 0; i < zeroBit; i++) {
					a0.insert(0, "0");
				}
			}
			char[] ch = a0.toString().toCharArray();
			StringBuilder sb = new StringBuilder();
			times--;
			for (int j = 0; times >= 0; times--) {
				StringBuilder tempSb = new StringBuilder();
//				int thousand = ch[j++] - '0';
				int hundred = ch[j++] - '0';
				int ten = ch[j++] - '0';
				int one = ch[j++] - '0';
//				System.out.println(thousand + "" + hundred + "" + ten + "" + one);
				System.out.println(hundred + "" + ten + "" + one);
//				tempSb.append(thousandDidit(thousand, times));
				tempSb.append(hundredDidit(hundred));
				tempSb.append(dealWithBelow100(ten, one));
				if (!tempSb.toString().isEmpty()) {
					tempSb.append(thousandTimes[times] + " ");
				}
				System.out.println(tempSb.toString());
				sb.append(tempSb.toString());
			}
			String result = sb.toString().trim();
			if (result.isEmpty()) {
				System.out.println("Zero");
			} else {
				System.out.println(result);
			}
		}
		in.close();
	}

//	private static String thousandDidit(int n, int index) {
//		if (0 == n)
//			return "";
//		return below10[n] + thousandTimes[index] + " ";
//	}

	private static String hundredDidit(int n) {
		if (0 == n)
			return "";
		return below10[n] + " Hundred ";
	}

	private static String dealWithBelow100(int ten, int one) {
		StringBuilder sb = new StringBuilder();
		if (ten >= 2) {
			sb.append(tenTimesBelow100[ten % 10] + " " + dealWithBelow20(one));
		} else {
			ten *= 10;
			sb.append(dealWithBelow20(ten + one));
		}
		return sb.toString();
	}

	private static String dealWithBelow20(int one) {
		if (one > 0) {
			return below10[one] + " ";
		}
		return "";
	}

}
