package impl;

import java.util.HashSet;
import java.util.Set;

import generics.MapTmp;

public class MapLikeImpl<K, V> implements MapTmp<K, V> {

	private Set<InterfTestImpl<K, V>> entry = new HashSet<InterfTestImpl<K, V>>();
	
	private K key;
	
	private V value;
	
	public MapLikeImpl() {
		super();
	}
	
	public MapLikeImpl(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public void put(K k, V v) {
		InterfTestImpl<K, V> e = new InterfTestImpl<K, V>(k, v);
		entry.add(e);
	}

	@Override
	public Set<InterfTestImpl<K, V>> entry() {
		return entry;
	}

}
