package map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author keqi
 */
public class MyEnumMap<K extends Enum<K>,V> implements Map<K,V> {
	
	private K[] keys;
	private V[] values;
	
	public MyEnumMap(Class<K> clazz) {
		K[] enumConstants = clazz.getEnumConstants();
		keys = (K[]) new Object[enumConstants.length];
		values = (V[]) new Object[enumConstants.length];
	}
	
	@Override
	public int size() {
		return 0;
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}
	
	@Override
	public boolean containsKey(Object key) {
		return false;
	}
	
	@Override
	public boolean containsValue(Object value) {
		return false;
	}
	
	@Override
	public V get(Object key) {
		return null;
	}
	
	@Override
	public V put(K key, V value) {
		return null;
	}
	
	@Override
	public V remove(Object key) {
		return null;
	}
	
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
	
	}
	
	@Override
	public void clear() {
	
	}
	
	@Override
	public Set<K> keySet() {
		return null;
	}
	
	@Override
	public Collection<V> values() {
		return null;
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		return null;
	}
}
