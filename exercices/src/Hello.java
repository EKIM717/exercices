import org.junit.Test;

/**
 * Test class
 * @author Administrator
 *
 */
public class Hello {

	public static void main(String[] args) {
		float a = Float.parseFloat("2.68888E+7");
		float b = Float.parseFloat("2");
		System.out.println(a / 10000000);
	}
	
	@Test
	public void t() {
		String a = "a";
		test(a);
	}
	
	public void test(String a) {
		
		System.out.println(a);
	}
}
