package javaSE.string;

public class StringBuilderTest {

	public static void main(String[] args) {
		testRemove();
	}
	
	private static void testRemove() {
		StringBuilder sb = new StringBuilder("aa");
		System.out.println(sb.delete(sb.length() - 1, sb.length()));
	}
	
}
