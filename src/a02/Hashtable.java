package a02;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * @author Katharina-Sophia Bolinski s791580, Toni Kluth s780025
 *
 * @param <T> Generischer Typ der Klasse 'Hashtable'
 */
public class Hashtable<T> implements Map {
	private LinkedList<KeyValuePair>[] hashtable;
	private int length;

	/**
	 * Konstruktor der Klasse 'Hashtable'. Initialisiert ein 'LinkedList<KeyValuePair>[]'
	 * und fuellt alle Indices mit leeren 'LinkedLists'.
	 * 
	 * @param size Die groesse des zu erstellenden 'LinkedList<KeyValuePair>[]'
	 */
	public Hashtable(int size) {
		hashtable = new LinkedList[size];
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new LinkedList<KeyValuePair>();
		}
	}
	
	/**
	 * Methode zum Einfuegen des Schluessel-Wert-Paars.
	 * 
	 * @param key 	Der Schluessel des Schluessel-Wert-Paar das in das 'LinkedList<KeyValuePair>[]'
	 * 				eingefuegt werden soll
	 * @param value Der Wert des Schluessel-Wert-Paar das in das 'LinkedList<KeyValuePair>[]'
	 * 				eingefuegt werden soll
	 * @return Object: falls es schon einen Wert mit Schluessel 'key' in der Map 
	 *         gibt, wird der alte Wert entfernt und zurueckgegeben; 
	 *         sonst wird 'null' zurueckgegeben
	 **/
	public Object put(Object key, Object value) {
		hashtable = checkAndResizeHashtable(hashtable);
		KeyValuePair keyValuePair = new KeyValuePair(key, value);				// Erstelle ein 'KeyValuePair' aus den uebergebenen Werten.
		int index = key.hashCode() % hashtable.length; 							// Ermittle den Index zum 'key'.
		if (hashtable[index].isEmpty()) {										// Wenn die Liste an Index 'index' leer ist...
			hashtable[index].add(keyValuePair);									// ... fuege 'KeyValuePair' an der Stelle ein.
		} else { 															
			for (int i = 0; i < hashtable[index].size(); i++) {
				if (hashtable[index].get(i).getKey().equals(key)) { 			// Vergleiche Keys.
					Object returnValue = hashtable[index].get(i).getValue();	// Packe alten 'value' in Hilfsfeld.
					hashtable[index].get(i).setValue(value);					// Ueberschreibe 'value'.
					return returnValue; 										// Gebe den alten 'value' zurueck.
				} else {
					hashtable[index].add(keyValuePair);							// Wenn 'key' nicht vorhanden ist, fuege 'KeyValuePair' hinzu.
				}																
			}																	
		}
		return null;
	}
	
	/**
	 * Methode zur Bestimmung des 'value' zu einem 'key' in Map
	 * 
	 * @param key Der Schluessel des gesuchten 'value'.
	 * @return Object: Gibt den Wert zum Schluessel 'key' zurueck, falls ein 
	 *         entsprechendes Schluessel-Wert-Paar vorhanden ist; 
	 *         sonst 'null'
	 **/
	public Object get(Object key) {
		int index = key.hashCode() % hashtable.length;							// Ermittle den Index zum 'key'.
		for (int i = 0; i < hashtable[index].size(); i++) {	
			if (hashtable[index].get(i).getKey().equals(key)) {					// Vergleiche Keys.
				Object returnValue = hashtable[index].get(i).getValue();		// Packe alten 'value' in Hilfsfeld.
				return returnValue;												// Gebe den alten 'value' zurueck.
			}
		}
		return null;															// Gibt 'null' zurueck, wenn 'key' nicht vorhanden ist.
	}

	/**
	 * Methode zum Loeschen Schluessel-Wert-Paar aus der Map 
	 * 
	 * @param key der Schluessel des zu loeschenden 'value'
	 * @return Object: der Wert zu dem Schluessel, falls ein entsprechendes 
	 *         Schluessel-Wert-Paar vorhanden ist; 
	 *         sonst 'null'
	 **/
	public Object remove(Object key) {
		int index = key.hashCode() % hashtable.length;							// Ermittle den Index zum 'key'.
		for (int i = 0; i < hashtable[index].size(); i++) {
			if (hashtable[index].get(i).getKey().equals(key)) { 				// Vergleiche Keys.
				Object returnValue = hashtable[index].get(i).getValue();		// Packe alten 'value' in Hilfsfeld.
				hashtable[index].remove();										// loesche Eintrag
				return returnValue;												// Gebe den alten 'value' zurueck.
			}
		}
		return null;															// Gibt 'null' zurueck, wenn 'key' nicht vorhanden ist.
	}
	
	/**
	 * Methode zum pruefen der Groesse des 'LinkedList<KeyValuePair>[]'.
	 * 
	 * @return int: die Groesse des 'LinkedList<KeyValuePair>[]'.
	 */
	public int getHashtableSize() {
		return hashtable.length;
	}
	
	/**
	 * Methode zum pruefen der Anzahl der Elemente in der 'LinkedList<KeyValuePair>[]'.
	 * 
	 * @return int: die Anzahl der Elemente der 'LinkedList<KeyValuePair>[]'.
	 */
	public int getElementCount() {
		int counter = 0;
		for (int i = 0; i < hashtable.length; i++) {
			if(!hashtable[i].isEmpty()) {
				for (int j = 0; j < hashtable[i].size(); j++) {
					if(!hashtable[i].get(j).equals(null))
						counter++;
				}
			}																			
		}
		return counter;
	}
	
	/**
	 * Methode prueft das Verhaeltnis von Elementen zu der 
	 * Groesse des ubergebenen 'LinkedList<KeyValuePair>[]'.
	 * Wenn das Verhaltnis > 2 ist, Erstelle ein neues 
	 * 'LinkedList<KeyValuePair>[]' und gebe es zurueck.
	 * Ansonsten gebe das ubergebene 'LinkedList<KeyValuePair>[]'
	 * unveraendert zurueck.
	 * 
	 * @param hashtableToCheck Das zu pruefende 'LinkedList<KeyValuePair>[]'
	 * @return LinkedList<KeyValuePair>[]: Gibt ein 'LinkedList<KeyValuePair>[]'.
	 */
	public LinkedList<KeyValuePair>[] checkAndResizeHashtable(LinkedList<KeyValuePair>[] hashtableToCheck) {
		if((hashtableToCheck.length/2) < this.getElementCount()) {
			LinkedList<KeyValuePair>[] helperHashtable;
			helperHashtable = new LinkedList[hashtableToCheck.length * 2];
			for (int i = 0; i < helperHashtable.length; i++) {
				helperHashtable[i] = new LinkedList<KeyValuePair>();
			}
			for (int i = 0; i < hashtableToCheck.length; i++) {
				if(!hashtableToCheck[i].isEmpty()) {
					for (int j = 0; j < hashtableToCheck[i].size(); j++) {
						if(!hashtableToCheck[i].get(j).equals(null)) {
							int helperIndex = hashtableToCheck[i].get(j).getKey().hashCode() % helperHashtable.length;
							KeyValuePair helperKeyValuePair = new KeyValuePair(hashtableToCheck[i].get(j).getKey(), hashtableToCheck[i].get(j).getValue());
							helperHashtable[helperIndex].add(helperKeyValuePair);
						}
					}
				}																			
			}
			return helperHashtable;
		}
		return hashtableToCheck;
	}

	@Override
	public String toString() {
		return "Hashtable [hashtable = " + Arrays.toString(hashtable) + "]";
	}

	
	private class KeyValuePair {		
		Object key;
		Object value;

		/**
		 * Der Konstruktor der inneren Klasse 'KeyValuePair'
		 * Hier wird ein Schluessel-Wert-Paar mit den uebergebenen 
		 * Parametern erstellt. 
		 * 
		 * @param key Der Schluessel des 'KeyValuePair'
		 * @param value Der Wert des 'KeyValuePair'
		 */
		protected KeyValuePair(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Getter-Methode fuer den Schluessel.
		 * 
		 * @return Object: Gibt 'key' zurueck 
		 */
		protected Object getKey() {
			return this.key;
		}

		/**
		 * Getter-Methode fuer den Wert.
		 * 
		 * @return Object: Gibt 'value' zurueck 
		 */
		protected Object getValue() {
			return this.value;
		}
		
		/**
		 * Setter-Methode fuer den Wert.
		 * 
		 * @param value Der Wert der im Schluessel-Wert-Paar
		 * 				geaendert werden soll
		 */
		protected void setValue(Object value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "KeyValuePair [key = " + key + ", value = " + value + "]";
		}

	} // Ende der inneren Klasse 'KeyValuePair'.

}
