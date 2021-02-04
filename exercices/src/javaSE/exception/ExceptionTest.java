package javaSE.exception;

public class ExceptionTest {

	public static void main(String[] args) {
		output2();
		
		
		
		
	}
	
	public static void output2() {
		try {
			float i = 10 / 0;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static void output() {
		try {
			float i = 10 / 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}
}
