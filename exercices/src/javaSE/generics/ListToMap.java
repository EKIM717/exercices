package javaSE.generics;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListToMap<K> {

	public static void main(String[] args) {
		
	}
	
	public <K, V> void convert(Map<K, Set<V>> map, K key, V v) {
		Set<V> set = null;
		if (map.containsKey(key)) {
			set = (Set<V>) map.get(key);
			set.add(v);
		} else {
			set = new HashSet<V>();
			set.add(v);
			map.put(key, set);
		}
	}
}
