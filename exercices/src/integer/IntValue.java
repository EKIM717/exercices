package integer;

public class IntValue {

	public static void main(String[] args) {
		int i = 9;
		Integer ref = new Integer(9);
		System.out.println(compare(i, ref));
	}
	
	private static boolean compare(int i, Integer ref) {
		return i == ref.intValue();
	}
	
}
