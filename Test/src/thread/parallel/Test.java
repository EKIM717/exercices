package thread.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		int N = 10000000;
		long[] c = new long[N];
		for (int i = 0; i < N; i++) {
			 c[i++] = i;
		}
		List<Long> list = new ArrayList<>();
		for (long ch : c) // create and start threads
			list.add(ch);
		long start = System.nanoTime();
		Optional<Long> cs = list.stream().parallel().reduce((e, bit)->e+=bit);
		long end = System.nanoTime();
		System.out.println(end - start);
		
		start = System.nanoTime();
		long r = 0;
		for (Long ch : list){r += ch;}
		end = System.nanoTime();
		System.out.println(end - start);
	}
	
	
}

