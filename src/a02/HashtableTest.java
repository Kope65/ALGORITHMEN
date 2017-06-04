package a02;

import java.util.Vector;

public class HashtableTest {

	public static void main(String[] args) {
		Hashtable<Object> hashtable = new Hashtable<Object>(7);
		
		hashtable.put("Hallo", "Welt");
		System.out.println("Value: " + hashtable.get("Hallo"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Servus", "Planet");
		System.out.println("Value: " + hashtable.get("Servus"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Hallo", "Weltraum");		
		System.out.println("Value: " + hashtable.get("Hallo"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("6", "12");
		System.out.println("Value: " + hashtable.get("6"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("0", "12");
		System.out.println("Value: " + hashtable.get("0"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.remove("Hallo");
		System.out.println("Value: " + hashtable.get("Hallo")   + " REMOVED");
		System.out.println(hashtable.get("Hallo"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Cat", "Dog");
		System.out.println("Value: " + hashtable.get("Cat"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Cat", "Hotdog");
		System.out.println("Value: " + hashtable.get("Cat"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Zahl", "15");
		System.out.println(hashtable.get("Zahl"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.remove("Cat");
		System.out.println("Value: " + hashtable.get("Cat"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put(16.258f, 120.456f);		
		System.out.println(hashtable.get(16.258f));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.remove(16.258f);
		System.out.println("Value: " + hashtable.get(16.258f) + " REMOVED");
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Wie", "So");
		System.out.println("Value: " + hashtable.get("Wie"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Wo", "Da");
		System.out.println(hashtable.get("Wo"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Moin", "Moin moin");
		System.out.println("Value: " + hashtable.get("Moin"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Tach", "Tschuess");
		System.out.println("Value: " + hashtable.get("Tach"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put(0, 11);
		System.out.println(hashtable.get(0));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.remove(0);
		System.out.println("Value: " + hashtable.get(0)   + " REMOVED");
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Elefant", "Gedaechtnis");
		System.out.println("Value: " + hashtable.get("Elefant"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Elefant", "Gedaechtnisluecke");
		System.out.println("Value: " + hashtable.get("Elefant"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put("Hola", "Adios");
		System.out.println("Value: " + hashtable.get("Tach"));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
		
		hashtable.put(30, 12.345678f);
		System.out.println("Value: " + hashtable.get(30));
		System.out.println(hashtable.toString());
		System.out.println("Anzahl der Eintraege im Hashtable: " + hashtable.getElementCount());
		System.out.println("Groesse des Hashtable: " + hashtable.getHashtableSize());
		System.out.println("*****");
	}
}