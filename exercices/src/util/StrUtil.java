package util;

public class StrUtil {

	public static void outputDbCol(int times) {
		for (int i = times; i > 0; i--)
			System.out.println("dbColumns.put(\"\", \"\");");
	}
	
	public static void main(String[] args) {
		outputDbCol(3);
	}
}
