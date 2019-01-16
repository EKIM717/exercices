package stream;

import java.util.Arrays;
import java.util.List;

public class Unit {
	
	public static List<Unit> getTestList() {
		return Arrays.asList(new Unit("a", 1), new Unit("b", 1), new Unit("c", 3), new Unit("d", 1));
	}
	private String sku;
	
	private Integer qnty;

	public Unit(String sku, Integer qnty) {
		this.sku = sku;
		this.qnty = qnty;
	}
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getQnty() {
		return qnty;
	}

	public void setQnty(Integer qnty) {
		this.qnty = qnty;
	}
}
