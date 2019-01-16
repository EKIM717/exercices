package finalTest;

public class Test {

	public static void main(String[] args) {
		System.out.println(test());
	}
	
	public static int test() {
		try {
			int result = 1 / 0;
			return result;
		} catch(ArithmeticException e) {
			System.out.println("catch");
			return 0;
		} finally {
			System.out.println("finally");
		}
	}
}
