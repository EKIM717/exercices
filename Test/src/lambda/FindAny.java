package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAny {

	public static void main(String[] args) {
		
		List<Integer> l = Arrays.asList(1,3,5,7,9,11,111,1111);
		Optional<Integer> i = l.stream().filter(a -> a > 3).parallel().findAny();
		System.out.println(i.get().toString());
	}
}
