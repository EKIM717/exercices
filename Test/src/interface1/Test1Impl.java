package interface1;

import java.util.ArrayList;
import java.util.List;

public class Test1Impl implements ITest1<Integer> {
	
	private String a;

	public static void main(String[] args) {
		ITest1<?> t = new Test1Impl();
		List<Integer> k = new ArrayList<Integer>();
		k.add(2);
		k.add(3);
		t.doSth(k);
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	@Override
	public <T> void doSth(List<T> t) {
		List<Integer> i = (List<Integer>) t;
		System.out.println("test1 " + i.getClass() + " " + i.size());
		for (int j : i) {
			System.out.println(j);
		}
	}
	
	
}
