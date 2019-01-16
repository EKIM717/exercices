package string;

public class SetTest {

	public static void main(String[] args) {
		A a = new A();
		a.setA("a");
		String s = a.getA();
		System.out.println(s);
		a.setA("b");
		System.out.println(s);
	}
}

class A {
	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	
}
