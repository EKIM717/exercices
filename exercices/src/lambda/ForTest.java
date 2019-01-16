package lambda;

import java.util.function.Supplier;

public class ForTest implements FunctionalTest<String> {

	public static void main(String[] args) {
		Supplier<ForTest> f = ForTest::new;
		System.out.println(f.get().test());
	}

	@Override
	public String test() {
		return "aaaa";
	}

}
