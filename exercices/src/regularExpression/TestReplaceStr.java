package regularExpression;

import java.util.regex.Pattern;

public class TestReplaceStr {

	public static void main(String[] args) {
		String test = "wa	n\tg_p\\t e\\tn	g";
//		test = test.replaceAll("\t", "");
//		System.out.println(test);
		test = test.replaceAll("\\\\t", "");
		System.out.println(test);
		String backup = test;
		test = test.replaceAll("\\t|\\\\t|\u0020|\\u3000", "");
		System.out.println(test);
		//replaceAllҲ�ǵ���Pattern��compile����,������ĵ�Ч
		backup = Pattern.compile("\\t|\\\\t|\u0020|\\u3000").matcher(backup).replaceAll("");
		System.out.println(backup);
	}
}
