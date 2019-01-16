package impl;

import generics.MapTmp;

public class InterfTestImpl<K, V> implements generics.MapTmp.Entry<K, V> {

	private K key;
	
	private V value;
	
	public InterfTestImpl() {
		super();
	}
	
	public InterfTestImpl(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public static void main(String[] args) {
		MapTmp<String, Integer> map = new MapLikeImpl<String, Integer>();
		map.put("s", 1);
		for (MapTmp.Entry<String, Integer> e : map.entry()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}
	
}
