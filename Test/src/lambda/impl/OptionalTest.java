package lambda.impl;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {

	public static void main(String[] args) {
		Optional.of(new Outer())
		.map(Outer::getNested)
		.map(Nested::getInner)
		.map(Inner::getFoo)
		.ifPresent(System.out::println);
		
		Outer outer = new Outer();
		System.out.println(resolve(()->outer.getNested().getInner().getFoo()).get());//(System.out::println);;
	}
	
	public static <T> Optional<T> resolve(Supplier<T> resolver) {
		try {
			T result = resolver.get();
			return Optional.ofNullable(result);
		} catch(NullPointerException ee) {
			return Optional.empty();
		}
	}
}

class Outer{
	Nested nested;

	public Nested getNested() {
		return nested;
	}

	public void setNested(Nested nested) {
		this.nested = nested;
	}

}

class Nested {
	Inner inner;

	public Inner getInner() {
		return inner;
	}

	public void setInner(Inner inner) {
		this.inner = inner;
	}
	
}

class Inner {
	Foo foo;

	public Foo getFoo() {
		return foo;
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
	}
	
}

class Foo {
	String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
}
