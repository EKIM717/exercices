package generics;

import java.util.Set;

import impl.InterfTestImpl;

public interface MapTmp<K, V> {


	void put(K k, V v);
	
	interface Entry<K, V> {
		K getKey();
		V getValue();
	}

	Set<InterfTestImpl<K, V>> entry();
}
