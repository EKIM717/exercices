package classTest;

public class Test {
	
	public static void main(String[] args) {
		Object[] o = new Object[]{new String("2"), new Integer(2), new Float(11.2f)};
//		Integer a = new Integer(o[1]);
		for(Object s: o){
			if(s instanceof String) {
				System.out.println("String");
			} else if(s instanceof Integer){
				System.out.println("Integer");
			} else if(s instanceof Float) {
				System.out.println("Float");
			}
		}
		String(Integer.class);
	}

	public static void String(Class clazz) {
		if(clazz == String.class) {
			System.out.println("String");
		} else if(clazz == Integer.class) {
			System.out.println("Integer");
		}
	}
}
