package a02;

public class HashtableTest {

	public static void main(String[] args) {
		Hashtable<String> hashtable = new Hashtable<String>(10);
		hashtable.put("Hallo", "Welt");
		System.out.println(hashtable.get("Hallo"));
		hashtable.remove("Hallo");
		System.out.println(hashtable.get("Hallo"));
	}

}
