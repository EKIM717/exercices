package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestModifyVar {

	public static void main(String[] args) {
		Var v1 = new Var();
		v1.setA(1);
		Var v2 = new Var();
		v2.setA(2);
		Var v3 = new Var();
		v3.setA(3);
		List<Var> l = Arrays.asList(v1, v2, v3);
		l.forEach(a -> ModifyVar(a));
		l.forEach(a -> System.out.println(a.getA()));
	}
	
	public static void ModifyVar(Var a) {
		a.setA(a.getA() + 1);
	}
}

class Var {
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	
}