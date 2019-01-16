package staticClass;

public class MainClass {

	public static void main(String[] args) {
		Test.test();
	}
	
	public static class Test {
		public String A = "a";
		
		public static void test() {
			System.out.println("hello world");
		}
	}
}
