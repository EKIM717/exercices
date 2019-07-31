package finally_test;

/**
 * ����finally���ִ�����
 * 1.ʲô����²�ִ��
 * 2.finally�����return ����Ⱥ�ִ��˳�����ʲô����
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
	 * 1.û�б�ִ��������tryû�б�ִ��
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
	 * ����ָ��ַ���
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
			System.out.println("��ʱ�Ļ������ͱ���i�������return ����Ѿ���ջ,������finally����Ĵ���ִ�к�,����Ѹı���ֵ20����");
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
			System.out.println("��ʱ�Ļ������ͱ���i��Ȼ��Ч,������finally����Ĵ���ִ�к�,���ֵ���ӵ�20");
			System.out.println("i=" + i);
		}
		System.out.println("-----------------");
		System.out.println("plus 10 before return");
		return i += 10;
	}
}
