package integer;

public class TempVar {

	public static void main(String[] args) {
		Integer i = new Integer(1);
		change(i);
		System.out.println(i);
	}
	
	
	private static void change(Integer i) {
		i = new Integer(i +1);
	}
	
}
