package download;

public class DownloadBar {

	public static void main(String[] args) throws InterruptedException {
		//�ļ��ܴ�С
		float totalSize = Float.valueOf(args[0]);
		char[] s = new char[100];
		for (int i = 0; i < s.length; i++)
			s[i] = ' ';
		
		//�ٷֱ�
		float rate = 0.0f;
		for (float i = 0; i <= totalSize; i++) {
			float decimal = i/totalSize;
			//�ٷֱ�
			rate = Math.round(decimal*10000)/100.0f;
			int index = Math.round(decimal*100);
			s[index] = '|';
			outputInfo(String.valueOf(s), rate);
			Thread.sleep(100);
		}
		//����������ǰٷְ�
		rate = 100;
		outputInfo(String.valueOf(s), rate);
	}
	
	/**
	 * 
	 * @param s
	 * @param rate
	 */
	private static void outputInfo(String s, float rate) {
		carragieReturn();
		System.out.format("[%s][%.1f%s]",s, rate, "%");
	}
	
	/**
	 * �س�
	 */
	private static void carragieReturn() {
		System.out.print("\r");
	}
	
	/**
	 * ����
	 */
	private static void lineFeed() {
		System.out.println('\n');
	}
}
