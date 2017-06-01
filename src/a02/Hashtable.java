package a02;

import java.util.LinkedList;

public class Hashtable<T> implements Map {

	private static Object[] hashtable;

	public Hashtable(int size) {
		hashtable = new Object[size];
	}

	public Object put(Object key, Object value) {
		int index = key.hashCode() % hashtable.length;
		Object returnvalue = hashtable[index];
		KeyValuePair keyValuePair = new KeyValuePair(key, value);
		hashtable[index] = keyValuePair; 
		return returnvalue;
	}

	public Object get(Object key) {
		int index = key.hashCode() % hashtable.length;
		return hashtable[index];
	}

	public Object remove(Object key) {
		int index = key.hashCode() % hashtable.length;
		Object returnvalue = hashtable[index];
		hashtable[index] = null;
		return returnvalue;
	}

	protected class KeyValuePair {
		private LinkedList<Object> list;

		public KeyValuePair(Object key, Object value) {
			list.add(key);
			list.add(value);
		}
	}

}
