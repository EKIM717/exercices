package longType;

public class Test {

	public static void main(String[] args) {
		System.out.println(get(1L) instanceof Long);
	}
	
	private static Object get(long l) {
		Object o = l;
		return o;
	}
}
