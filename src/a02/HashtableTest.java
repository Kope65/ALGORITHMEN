package a02;

import java.util.Vector;

public class HashtableTest {

	public static void main(String[] args) {
		Hashtable<Object> hashtable = new Hashtable<Object>(1);
//		String[] stringArray_1 = new String[] {"Hallo", "Welt", "wie", "geht's", "denn", "so?"};
//		String[] stringArray_2 = new String[] {"Gut", "Und", "selbst?"};
		
		hashtable.put("Hallo", "Welt");
		System.out.println(hashtable.get("Hallo"));
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		
		hashtable.put("Hallo", "Weltraum");		
		System.out.println(hashtable.get("Hallo"));
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		
		hashtable.put("6", "12");
		System.out.println(hashtable.get("6"));
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		
		hashtable.remove("Hallo");
		System.out.println(hashtable.get("Hallo"));
		System.out.println(hashtable.get("6"));
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		
		hashtable.put("Cat", "Dog");
		System.out.println(hashtable.get("Cat"));
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		
		hashtable.put("Cat", "Hotdog");
		System.out.println(hashtable.get("Cat"));
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		
		hashtable.put("Zahl", "15");
		System.out.println(hashtable.get("Zahl"));
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		
		hashtable.remove("Cat");
		System.out.println(hashtable.get("Cat"));
		System.out.println(hashtable.get("Zahl"));
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		
		hashtable.put(16.258f, 120.456f);		
		System.out.println(hashtable.get(16.258f));
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		
		hashtable.remove(16.258f);
		System.out.println(hashtable.get(16.258f));
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		
		System.out.println(hashtable.toString());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
//		hashtable.put(stringArray_1, stringArray_2);
//		System.out.println(hashtable.get(stringArray_1));
//		hashtable.remove(stringArray_1);
//		System.out.println(hashtable.get(stringArray_1));		
	}
}