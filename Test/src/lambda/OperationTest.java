package lambda;

import java.util.function.BinaryOperator;

public class OperationTest {

	public static void main(String[] args) {
		BinaryOperator<Integer> i = (x , y)-> x*3+y;
		int a = i.apply(1, 2);
		System.out.println(a);
	}
}
