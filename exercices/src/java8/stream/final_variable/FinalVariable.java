package java8.stream.final_variable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class FinalVariable {

	public static void main(String[] args) {
		// 局部内部类和匿名内部类访问的局部变量必须由final修饰，java8开始，可以不加final修饰符，由系统默认添加
		// final int age = 0;
		int age = 0;
		// 下面一行代码会导致编译出错,如果去掉注释,会把s当成是可修改引用的变量,
		//Local variable age defined in an enclosing scope must be final or effectively final
		// 错误: 从内部类引用的本地变量必须是最终变量或实际上的最终变量
//		age=11;
		A a = new A() {
			public void test() {
				// Cannot refer to a non-final variable age
				// inside an inner class defined in a different method
				System.out.println(age);
			}
		};
		a.test();
		List<String> l = Arrays.asList("a", "b", "c");
		Predicate<String> p = e -> Objects.equals(age, e);
		l.stream().filter(p).forEach(System.out::println);
	}

}

// 接口
interface A {
	void test();
}
