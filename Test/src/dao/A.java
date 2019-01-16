package dao;

public class A extends Super {

	public A() {
		this.table = "aa";
	}
	
//	private String table = "aa";
	
	public static void main(String[] args) {
		A a = new A();
		a.get("AA0001");
	}
}
