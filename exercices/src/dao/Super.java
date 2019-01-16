package dao;

public class Super {

	protected String table = "super";
	
	protected void get(String sku) {
		System.out.println(table + "   " + sku);
	}
}
