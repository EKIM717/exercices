
public class GC {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("asfdasfgasg");
		clear(sb);
		System.out.println(sb);
	}
	
	/**
	 * �޷���ֵ0
	 * @param o
	 */
	public static void clear(Object o) {
		o = null;
	}
}
