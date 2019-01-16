package dao;

public class B extends Super {

	public B() {
		super();
		this.table = "BB";
	}
//	private String table = "b";
	
	public void get(String sku) {
		get(sku);
	}
	
	public static void main(String[] args) {
		B a = new B();
		a.get("AA0001");
	}
}
