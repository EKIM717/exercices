package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ConcatString {

	public static void main(String[] args) {
		List<String> l = Arrays.asList("a", "b", "c");
		Optional<String> s = l.stream().reduce((acc, item)->{
		System.out.println("acc : "  + acc);
        acc += item;
        System.out.println("item: " + item);
        System.out.println("acc+ : "  + acc);
        System.out.println("--------");
        return acc;});
		System.out.println(s.get());
		
		List<Integer> li = Arrays.asList(1,2,3,4);
		Optional<Integer> is = li.stream().reduce((acc, item)->{
			System.out.println("acc : "  + acc);
        acc += item;
        System.out.println("item: " + item);
        System.out.println("acc+ : "  + acc);
        System.out.println("--------");
        return acc;});
		System.out.println(is.get());
		
	}
}
