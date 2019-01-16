package recursion;

public class Test {

	public static void main(String[] args) {
		for (int i = 0; i < 9; i++)
			System.out.format("%d ", recursion(i));
	}
	
	/**
	 * ì³²¨ÄÇÆõÊýÁÐ
	 * @param num
	 * @return
	 */
	public static int recursion(int num) {
		if (num < 1)
			return 0;
		if (num == 1 || num == 2)
			return 1;
		return recursion(num - 1) + recursion(num - 2);
	}
}
