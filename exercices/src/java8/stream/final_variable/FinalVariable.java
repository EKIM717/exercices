package java8.stream.final_variable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class FinalVariable {

	public static void main(String[] args) {
		// �ֲ��ڲ���������ڲ�����ʵľֲ�����������final���Σ�java8��ʼ�����Բ���final���η�����ϵͳĬ�����
		// final int age = 0;
		int age = 0;
		// ����һ�д���ᵼ�±������,���ȥ��ע��,���s�����ǿ��޸����õı���,
		//Local variable age defined in an enclosing scope must be final or effectively final
		// ����: ���ڲ������õı��ر������������ձ�����ʵ���ϵ����ձ���
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

// �ӿ�
interface A {
	void test();
}
