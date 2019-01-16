package java8.stream;

import java.util.Arrays;
import java.util.Optional;

import enumTest.StrManager;

public class Test {

	public static void main(String[] args) {
//		System.out.println(findAny());
	}
	
	public static boolean findAny() {
		String[] s = {"a", "b"};
		Optional<String> op = Arrays.asList(s).stream()
				.filter(str -> (StrManager.isEmpty(str)))
				.findFirst();
		return (op.isPresent());
	}
}
