package string;

public class SplitTest {

	public static void main(String[] args) {
		test("");
	}
	
	public static void test(String s) {
		String[] arr = s.split("\\t");
		for (String str : arr)
			System.out.println(str);
	}
	
}
