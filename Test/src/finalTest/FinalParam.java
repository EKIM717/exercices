package finalTest;

/**
 * final ÐÞÊÎ²ÎÊý
 * @author Administrator
 *
 */
public class FinalParam {

	public static void main(String[] args) {
		T t = new T();
		t.setA(1);
		testNoFinal(t);
		System.out.println("out of the method:" + t.getA());
		System.out.println("------------------------");
		testFinal(t);
		System.out.println("out of the method:" + t.getA());
	}
	
	public static void testFinal(final T t) {
		System.out.println("testing final param");
		System.out.println("source value:" + t.getA());
		t.setA(2);
		System.out.println("in the method:" + t.getA());
	}
	
	public static void testNoFinal(T t) {
		System.out.println("testing no final param");
		System.out.println("source value:" + t.getA());
		t = new T();
		t.setA(2);
		System.out.println("in the method:" + t.getA());
	}
}


class T {
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	int a;
	
}