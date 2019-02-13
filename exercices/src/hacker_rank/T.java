package hacker_rank;

public class T {

	public static void main(String[] args) {
		long a = 1;
		for (int i = 500; i > 250; i--) {
			a *= i;
			System.out.println(i + " " + a);
		}
	}
}
