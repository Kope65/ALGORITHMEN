package a02;

public class HashtableTest {

	public static void main(String[] args) {
		Hashtable<Object> hashtable = new Hashtable<Object>(10);
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
	
	
		
		
	}
}