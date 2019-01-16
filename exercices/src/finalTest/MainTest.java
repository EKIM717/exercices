package finalTest;
/**
 * String是final修饰的class,不可再被更改,所以能有子类继承
 * @author Mike
 *
 */
//public class MainTest extends String {
public class MainTest {

}

class A {
	public static final String getA() {
		return "A";
	}
}

class B {
	public static String getA() {
		return null;
		
	}
}
