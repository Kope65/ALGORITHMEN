package a02;

import java.util.LinkedList;

public class Hashtable<T> implements Map {

	private LinkedList<KeyValuePair>[] hashtable;

	public Hashtable(int size) {
		hashtable = (LinkedList<KeyValuePair>[]) new LinkedList[size];
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new LinkedList<KeyValuePair>();
		}
	}

	public Object put(Object key, Object value) {
		KeyValuePair keyValuePair = new KeyValuePair(key, value);
		int index = key.hashCode() % hashtable.length;
		if (hashtable[index].isEmpty()) {			
			LinkedList<KeyValuePair> list = new LinkedList<KeyValuePair>();
			list.add(keyValuePair);
			hashtable[index] = list;
		} else {
			for (int i = 0; i < hashtable[index].size(); i++) {
				if (hashtable[index].get(i).getKey().equals(key)) {
					Object returnValue = hashtable[index].get(i).getValue();
					hashtable[index].get(i).setValue(value);
					return returnValue;
				} else {
					hashtable[index].add(keyValuePair);
				}
			}
		}
		return null;
	}

	public Object get(Object key) {
		int index = key.hashCode() % hashtable.length;
		for (int i = 0; i < hashtable[index].size(); i++) {
			if (hashtable[index].get(i).getKey().equals(key)) {
				Object returnValue = hashtable[index].get(i).getValue();
				return returnValue;
			}
		}
		return null;
	}

	public Object remove(Object key) {
		int index = key.hashCode() % hashtable.length;
		for (int i = 0; i < hashtable[index].size(); i++) {
			if (hashtable[index].get(i).getKey().equals(key)) {
				Object returnValue = hashtable[index].get(i).getValue();
				hashtable[index].remove();
				return returnValue;
			}
		}
		return null;
	}

	private class KeyValuePair {
		Object key;
		Object value;

		protected KeyValuePair(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		protected Object getKey() {
			return this.key;
		}

		protected Object getValue() {
			return this.value;
		}

		protected void setValue(Object value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "KeyValuePair [key=" + key + ", value=" + value + "]";
		}

	} // end of inner class KeyValuePair

}
