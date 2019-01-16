
public class ReplaceFourStr {

	public static String removeFourChar(String content) {
		byte[] conbyte = content.getBytes();
		for (int i = 0; i < conbyte.length; i++) {
			System.out.println("第" + (i+1) + "元素的二进制:" + Integer.toBinaryString(conbyte[i]));
			if ((conbyte[i] & 0xF8) == 0xF0) {
				for (int j = 0; j < 4; j++) {
//					System.out.println("变化前----" + Integer.toBinaryString(conbyte[i+j]));
					conbyte[i+j]=0x30;
					System.out.println("变化后----" + "00" + Integer.toBinaryString(conbyte[i+j]));
				}  
				i += 3;
			}
		}
		content = new String(conbyte);
		StringBuffer test = new StringBuffer();
		for(int i = 0; i < conbyte.length; i++) {
			test.append(Integer.toBinaryString(conbyte[i]));
		}
		System.out.println(test);
		System.out.println(content);
		return content = content.replaceAll("0000", "");
		
	}
	public static void main(String[] args) {
//		byte[] b = new byte[]{'b','a',(byte) 0xF0,(byte)0xF0,(byte)0x9F,'2','3','4'};
//		String title = new String(b);//Llfldakf;dsk。f????????????daslfjdsa;lfkjdsd‘j‘l‘f‘k‘d‘j‘sa‘l‘k";
//		System.out.println(title);
//		System.out.println(removeFourChar(title).replaceAll("0000", ""));
		
//		byte[] a = new byte[]{65,66};
//		String s = new String(a);
//		System.out.println(s);
//		System.out.println(removeFourChar(s).replaceAll("0000", ""));
//		for(byte i : a) {
//			System.out.println(Integer.toBinaryString(i));
//		}
		
		byte i = 0b01111110;
		char c = Character.valueOf((char) i);
		System.out.println(i);
		System.out.println(c);
		
	}
}
