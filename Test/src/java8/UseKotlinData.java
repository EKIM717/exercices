package java8;

import kotlin.DataType;

public class UseKotlinData {

	private DataType dataType;

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public static void main(String[] args) {
		DataType dt = new DataType(1);
		System.out.println(dt.getId());
	}
	
}
