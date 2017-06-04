package a02;

import java.util.Vector;

public class HashtableTest {

	public static void main(String[] args) {
		Hashtable<Object> hashtable = new Hashtable<Object>(10);
//		String[] stringArray_1 = new String[] {"Hallo", "Welt", "wie", "geht's", "denn", "so?"};
//		String[] stringArray_2 = new String[] {"Gut", "Und", "selbst?"};
		
		hashtable.put("Hallo", "Welt");
		System.out.println(hashtable.get("Hallo"));
		hashtable.put("Hallo", "Weltraum");		
		System.out.println(hashtable.get("Hallo"));
		hashtable.put("6", "12");
		System.out.println(hashtable.get("6"));
		hashtable.remove("Hallo");
		System.out.println(hashtable.get("Hallo"));
		System.out.println(hashtable.get("6"));
		hashtable.put("Cat", "Dog");
		System.out.println(hashtable.get("Cat"));
		hashtable.put("Cat", "Hotdog");
		System.out.println(hashtable.get("Cat"));
		hashtable.put("Zahl", "15");
		System.out.println(hashtable.get("Zahl"));
		hashtable.remove("Cat");
		System.out.println(hashtable.get("Cat"));
		System.out.println(hashtable.get("Zahl"));
		hashtable.put(16.258f, 120.456f);		
		System.out.println(hashtable.get(16.258f));
//		hashtable.put(stringArray_1, stringArray_2);
//		System.out.println(hashtable.get(stringArray_1));
//		hashtable.remove(stringArray_1);
//		System.out.println(hashtable.get(stringArray_1));		
	}
}