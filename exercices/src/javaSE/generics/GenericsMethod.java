package javaSE.generics;

public class GenericsMethod {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		test(A.class);
	}

	public static <T extends A> void test(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		T obj = clazz.newInstance();
		obj.setA("a");
		System.out.println(obj.getA());
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
