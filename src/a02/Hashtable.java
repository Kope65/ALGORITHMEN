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

	
	/**
	 * Methode zum Einfügen des KeyValue-Paares
	 * @param key
	 * @param value
	 * @return falls es schon einen Wert mit Schluessel key in der Map 
	 *         gab, wird der alte Wert entfernt und zurueckgegeben; 
	 *         sonst wird null zurueckgegeben
	 *  **/
	
	public Object put(Object key, Object value) {
		KeyValuePair keyValuePair = new KeyValuePair(key, value);
		int index = key.hashCode() % hashtable.length; 						// Formel zur Berechnung
		if (hashtable[index].isEmpty()) {									//wenn leer, dann...
			LinkedList<KeyValuePair> list = new LinkedList<KeyValuePair>(); //...neue LinkedList und...
			list.add(keyValuePair); 										//..füge keyValuePair zur LinkedList hinzu
			hashtable[index] = list;
		} else { 															//sonst,...
			for (int i = 0; i < hashtable[index].size(); i++) {
				if (hashtable[index].get(i).getKey().equals(key)) { 		//...vergleiche keys
					Object returnValue = hashtable[index].get(i).getValue();
					hashtable[index].get(i).setValue(value);
					return returnValue; 									// und gebe Value(Wert) aus
				} else {
					hashtable[index].add(keyValuePair);
				}
			}
		}
		return null;
	}

	
	/**
	 * Methode zur Bestimmung des Values zu einem Key in Map
	 * @param key
	 * @return den Wert zum Schluessel key, falls ein 
	 *         entsprechendes Schluessel-Wert-Paar vorhanden ist; 
	 *         null sonst
	 * **/
	
	public Object get(Object key) {
		int index = key.hashCode() % hashtable.length;						// Formel zur Berechnung
		for (int i = 0; i < hashtable[index].size(); i++) {
			if (hashtable[index].get(i).getKey().equals(key)) {				// zum vergleichen wir equals verwendet
				Object returnValue = hashtable[index].get(i).getValue();	//
				return returnValue;											// gebe Value(Wert) aus
			}
		}
		return null;
	}

	/**
	 * Methode zum Löschen KeyValue-Paares aus der Map 
	 * @param key der Schluessel 
	 * @return der Wert zu dem Schluessel, falls ein entsprechendes 
	 *         Schluessel-Wert-Paar vorhanden ist; 
	 *         null sonst
	 *  **/
	
	public Object remove(Object key) {
		int index = key.hashCode() % hashtable.length;						// Formel zur Berechnung
		for (int i = 0; i < hashtable[index].size(); i++) {
			if (hashtable[index].get(i).getKey().equals(key)) { 			// zum vergleichen wir equals verwendet
				Object returnValue = hashtable[index].get(i).getValue();	//
				hashtable[index].remove();									// lösche Eintrag
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