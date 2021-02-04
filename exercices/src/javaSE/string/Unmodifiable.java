package javaSE.string;

import java.util.HashMap;
import java.util.Map;

public class Unmodifiable {

	public static void main(String[] args) {
		String key;
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 10; i++) {
			key = i + "";
			map.put(key, key);
		}
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
		}
	}
}
