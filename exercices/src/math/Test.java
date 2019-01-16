package math;

/**
 * 测试
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		
	}
	
	/**
	 * 四舍五入
	 */
	public static void round() {
		System.out.println(Math.round(12.123));
		System.out.println(Math.round(12.5678));
	}
	
	/**
	 * 向上取整
	 */
	public static void ceil() {
		float f = 0.00001f;
		System.out.println((Math.ceil(f)));
	}
}
