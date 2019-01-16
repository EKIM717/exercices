package lambda;

import java.util.Arrays;
import java.util.List;

public class ReduceT {

	public static void main(String[] args) {
		List<Float> list = Arrays.asList(.1f, .2f, 1.3f);
		Float total = list.stream().reduce((p, p2)-> p + p2).get();
		System.out.println(total);
	}
}
