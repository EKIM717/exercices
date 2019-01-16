package staticTest;

import java.util.HashMap;
import java.util.Map;

public class StaticField {

	private static Map<Types, Integer> map1;
	
	
	private static void initMap() {
		if(null == map1) {
			Map<Types, Integer> map = new HashMap<Types, Integer>();
			map.put(Types.NULL, Types.NULL.getCode());
			map.put(Types.FULL, Types.FULL.getCode());
			map1 = map;
		}
	}
	
	public static Integer get(Types key) {
		initMap();
		return map1.get(key);
	}
	
	public static void main(String[] args) {
		System.out.println(StaticField.get(Types.NULL));
		System.out.println(StaticField.get(Types.FULL));
	}
	
}

