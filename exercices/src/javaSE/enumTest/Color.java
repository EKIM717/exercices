package javaSE.enumTest;

import java.util.HashMap;
import java.util.Map;

public enum Color {
	RED, GREEN, BLUE;
	//实例构造方法不能调用static修饰的变量
	//Color() { colorMap.put(toString(), this); }
	static final Map<String,Color> colorMap =
	    new HashMap<String,Color>();
	
	static final TestObject o = new TestObject();
	
	static final Coin c = Coin.DIME;
	//以下才是正确写法
	static {
		for (Color c : Color.values())
			colorMap.put(c.toString(), c);
		
		o.setS("abc");
	}
	
	public static void main(String[] args) {
	}
}
