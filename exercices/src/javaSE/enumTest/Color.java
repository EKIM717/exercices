package javaSE.enumTest;

import java.util.HashMap;
import java.util.Map;

public enum Color {
	RED, GREEN, BLUE;
	//ʵ�����췽�����ܵ���static���εı���
	//Color() { colorMap.put(toString(), this); }
	static final Map<String,Color> colorMap =
	    new HashMap<String,Color>();
	
	static final TestObject o = new TestObject();
	
	static final Coin c = Coin.DIME;
	//���²�����ȷд��
	static {
		for (Color c : Color.values())
			colorMap.put(c.toString(), c);
		
		o.setS("abc");
	}
	
	public static void main(String[] args) {
	}
}
