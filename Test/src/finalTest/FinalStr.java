package finalTest;

public class FinalStr {

	public static void main(String[] args) {
		
	}
	
	/**
	 * 测试字符串类型final参数不可修改
	 * 下面会编译不通过
	 * @param a
	 */
	private static void test(final String a) {
//		a = "222";
	}
}
