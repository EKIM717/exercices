package staticTest;

public enum Types {
	
	NULL(1, "null"),
	FULL(2, "full");
	
	private Types(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private int code;
	
	private String msg;

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
