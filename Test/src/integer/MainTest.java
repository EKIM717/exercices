package integer;

public class MainTest {

	public static void change(Integer i) {
		i++;
	}
	
	public static void change(int[] a) {
		a[0]++;
		a[1]++;
	}
	
	public static void test() {
		Integer i = new Integer(1);
		change(i);
		System.out.println(i);
		
		int[] a = new int[]{1, 2};
		change(a);
		for (int j : a) {
			System.out.println(j);
		}
	}
	
	public static void eql() {
		Integer i = new Integer(10000);
		int a = 10000;
		System.out.println(a == i);
	}
	
	public static void main(String[] args) {
		eql();
	}
}
