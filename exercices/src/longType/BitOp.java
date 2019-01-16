package longType;

public class BitOp {

	public static void main(String[] args) throws InterruptedException {
//		Thread.sleep(200);
		long a = testRate();
		System.out.println("除法:" + a);
//		long b = testBitOp();
//		System.out.println("移位:" + b);
	}
	
	public static long testBitOp() {
		int a = 3;
		int b = 1;
		long begin;// = System.nanoTime();
		long end;// = System.nanoTime();
		begin = System.nanoTime();
		for (int i = 0; i < 1000000; i ++) {
			b = a<<2;
		}
		
		end = System.nanoTime();
		return end-begin;
	}
	
	public static long testRate() {
		int a = 3;
		int b = 1;
		long begin;// = System.nanoTime();
		long end;// = System.nanoTime();
		begin = System.nanoTime();
		for (int i = 0; i < 1000000; i ++) {
			b = a * 4;
		}
		end = System.nanoTime();
		return end-begin;
	}
	
	public static void testMove() {
		int a = 1;
		int b = a<<1;
		System.out.println("a " + a);
		System.out.println("a<<1 " + b);
		b = a<<1 + a<<1;
		System.out.println("a " + a);
		System.out.println("a<<1 + a<<1 " + b);
		System.out.println("相当于 a<<(1 + a)<<1 " + (a<<(1 + a)<<1));
		b = a<<1 + a<<1 + a<<1;
		System.out.println("a " + a);
		System.out.println("a<<1 + a<<1 + a<<1 " + b);
		System.out.println("相当于 a<<(1 + a)<<(1 + a)<<1 " + (a<<(1 + a)<<(1 + a)<<1));
	}
}
