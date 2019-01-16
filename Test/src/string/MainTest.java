package string;

public class MainTest {

	public static void main(String[] args) {
		String s = "abc";
		String[] t = s.split("\\|");
		for (String ss : t)
			System.out.println(ss);
	}
	
}
