package integer;

public class Cache {

	public static void main(String[] args) {
		Integer i = 2018, a = 2018;
		System.out.println("a == i  " + (a == i));
		System.out.println("a == i.intValue()  " + (a == i.intValue()));
		int b=2018;
		System.out.println("b == i  " + (b == i));
		Integer c = 100, d = 100;
		System.out.println("c == d  "  + (c == d));
		
		//�������,������ -128~127֮�䶼��������==�ж�
		Integer one = -128;
		Integer one1 = -128;
		System.out.println(one == one1);
		
		one = 127;
		one1 = 127;
		System.out.println(one == one1);
	}
}
