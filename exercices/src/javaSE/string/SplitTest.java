package javaSE.string;

public class SplitTest {

	public static void main(String[] args) {
//		test("");
		test2("|2|");
	}
	
	public static void test(String s) {
		String[] arr = s.split("\\t");
		for (String str : arr)
			System.out.println(str);
	}
	
	public static void test2(String s) {
		String[] arr = s.split("\\|");
		System.out.println(arr.length);
		for (String str : arr)
			System.out.println(str);
	}
	
}
