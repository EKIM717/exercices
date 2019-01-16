package lambda;

@FunctionalInterface
public interface Convert<S, T> {

	T convert(S s);
}
