package finally_test;

/**
 * 测试finally语句执行情况
 * 1.什么情况下不执行
 * 2.finally语句块和return 语句先后执行顺序根据什么而定
 * @author Administrator
 *
 */
public class T {

	public static void main(String[] args) {

		System.out.println("finally block no Execution tryBlockNoConditionToExecute");
		tryBlockNoConditionToExecute();
		outputSplitStr();
		System.out.println("System.exit(int code);");
		outputSplitStr();
		System.out.println("finally block after return");
		int i = testFinallyExcuteAfter();
		System.out.println("-----------------");
		System.out.println("get the return result i=" + i);
		outputSplitStr();
		System.out.println("finally block before return");
		i = testFinallyExcuteBefore();
		System.out.println("-----------------");
		System.out.println("get the return result i=" + i);
	}
	
	/**
	 * 1.没有被执行是由于try没有被执行
	 */
	private static void tryBlockNoConditionToExecute() {
		boolean b = false;
		if (b) {
			try {
				System.out.println("try block");
			} finally {
				System.out.println("finally block");
			}
		}
	}

	/**
	 * 输出分隔字符串
	 */
	private static void outputSplitStr() {
		System.out.println();
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < 100; index++)
			sb.append("-");
		System.out.println(sb.toString());
		System.out.println();
	}

	/**
	 * 
	 * @return
	 */
	public static int testFinallyExcuteAfter () {
		int i = 0;
		try {
			System.out.println("-----------------");
			System.out.println("try block");
			System.out.println("i=" + i);
			
			System.out.println("-----------------");
			System.out.println("i=" + i);
			System.out.println("plus 10 before return");
			return i += 10;
		} finally {
			i += 10;
			System.out.println("-----------------");
			System.out.println("finally block");
			System.out.println("此时的基本类型变量i在上面的return 语句已经出栈,所以在finally语句块的代码执行后,不会把改变后的值20返回");
			System.out.println("i=" + i);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static int testFinallyExcuteBefore () {
		int i = 0;
		try {
			System.out.println("-----------------");
			System.out.println("try block");
			System.out.println("i=" + i);
		} finally {
			i += 10;
			System.out.println("-----------------");
			System.out.println("finally block");
			System.out.println("此时的基本类型变量i依然有效,所以在finally语句块的代码执行后,会把值增加到20");
			System.out.println("i=" + i);
		}
		System.out.println("-----------------");
		System.out.println("plus 10 before return");
		return i += 10;
	}
}
