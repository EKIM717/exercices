package draw;

import java.io.IOException;

public class DrawPicture {
	
	public static String[][] test = {
			{" ------- ------- ------- -------"},
			{"| ***** |       |*     *|*     *|"},
			{"|   *   | *   * |*     *| *   * |"},
			{"|   *   |* * * *|*     *|  * *  |"},
			{"|   *   |*  *  *|** * **|   *   |"},
			{"|   *   | *   * |*     *|   *   |"},
			{"|   *   |  * *  |*     *|   *   |"},
			{"| ***** |   *   |*     *|   *   |"},
			{" ------- ------- ------- -------"},
	};

	/**
	 * �س�
	 */
	public static void reset() {
		System.out.print("\r");
	}
	
	/**
	 * �������
	 * @param array
	 */
	public static void outputArray(String[] array) {
		for (String s : array) {
			System.out.print(s);
		}
	}
	public static String[][] array = new String[4][6];
	
	  /**
     * ����̨����
     * @throws IOException
     * @throws InterruptedException
     */
//    public static void cls() throws IOException, InterruptedException
//    {
//        //// �½�һ�� ProcessBuilder����Ҫִ�е������� cmd.exe�������� /c �� cls
//        new ProcessBuilder("cmd", "/c", "cls")
//                // �� ProcessBuilder ���������ܵ��� Java �Ľ��̽��й�������������ķ���ֵҲ��һ��
//                // ProcessBuilder
//                .inheritIO()
//                // ��ʼִ�� ProcessBuilder �е�����
//                .start()
//                // �ȴ� ProcessBuilder �е���������ִ�����
//                // ������ȴ��������������������������������
//                .waitFor(); // ��������
//    }
    
    public static String[] outputLineVertical(boolean isStart) throws InterruptedException {
    	String[] temp = array[0].clone();
    	if (isStart) {
    		for (int k = 0; k < temp.length; k++) {
    			temp[k] = "-";
    			for (int j = 0; j < 4; j++) {
    				outputArray(temp);
    			}
    			Thread.sleep(300L);
//    			reset();
    		}
    	} else {
    		for (int k = temp.length - 1; k >= 0; k--) {
    			temp[k] = "-";
    			for (int j = 0; j < 4; j++) {
    				outputArray(temp);
    				System.out.print(" ");
    			}
    			Thread.sleep(300L);
//    			reset();
    		}
    	}
    	return temp;
    }
    
    public static String[] step1() throws InterruptedException {
    	outputLineVertical(false);
		System.out.println("\n\n\n");
		String[] temp = outputLineVertical(true);
		System.out.println();
		return temp;
    }
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Thread.sleep(2000L);
		int count = 0;
		for (String[] arr : test) {
			System.out.println(arr[0].toCharArray());
			for (char c : arr[0].toCharArray()) {
				if (c == '*') {
					count++;
				}
			}
//			char[] cArray = arr[0].toCharArray();
//			for (int i = 0; i < cArray.length; i++) {
//				if (cArray[i] == ('*')) {
//					++count;
//				}
//				for (int j = 0; j <= i; j++) {
//					Thread.sleep(1L);
//					System.out.print(cArray[j]);
//				}
////				System.out.print("\r");
//			}
		}
		System.out.println("total count: " + count);
//		
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array[i].length; j++) {
//				array[i][j] = " ";
//			}
//		}
//		
//		String[] temp = step1();
//
//		for (String s : a) {
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			step2(temp);
//		}
////		
		
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < 4; j++) {
//				for (int k = array[i].length - 1; k >= 0; k--) {
//					array[i][k] = "-";
//					outputArray(array[i]);
//				}
//			}
//			Thread.sleep(1000L);
//			reset();
//		}
	}
	
	public static String[] a = new String[5];
	
	static {
		for (int i = 0; i < a.length; i++) {
			a[i] = "";
		}
	}
	
	public static int b = 0;

	private static void step2(String[] temp) throws InterruptedException {
		Thread.sleep(500L);
		System.out.println();
		//
		System.out.print(" ");
		for (String s : temp) {
			System.out.print(s);
		}
		System.out.println();
		a[b++] = "|";
		for (String s : a) {
			System.out.println(s);
		}
		//
		System.out.print(" ");
		for (String s : temp) {
			System.out.print(s);
		}
	}
}
