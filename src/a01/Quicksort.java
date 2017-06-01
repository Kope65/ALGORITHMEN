package a01;

/**
 * @author Katharina-Sophia Bolinski s791580, Toni Kluth s780025
 */

public class Quicksort {

	// Unsortiertes Test-Array
	protected static int[] intArr = { 16, 2300, 14, 15, 10, 1, -5, 200, 199,
			201, -31, 3, 55, -157, -1250, 5, 5, 6, 7, 8, 17, -17, 111, -111, 1111,
			125, 145, 159, 426, 428, 456, 441, 2356, 36365, 4575, 5698, 54447,
			451124, 1552, 45863, 25863, 15523, 565665, 2254, 5484, 121658,
			15156, 6555 };
	protected static String filepathRand = "./FileIntArrayMitBeispielen/Rand100_1";
	protected static String filepathSort = "./FileIntArrayMitBeispielen/Sort100_1";
	protected static long startTime;
	protected static long endTime;

	/**
	 * Die main-Methode sortiert verschiedene Testfaelle und gibt das sortierte
	 * Array und die benoetigte Zeit in Millisekunden aus.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Testfall 1 mit 'intArr'
		startTime = System.currentTimeMillis();
		print(sort(intArr));
		endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime) + "ms");

		// Testfall 2 mit 'Rand100_1'
		startTime = System.currentTimeMillis();
		print(sort(FileIntArray.FileToIntArray(filepathRand)));
		endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime) + "ms");

		// Testfall 3 mit 'Sort100_1'
		startTime = System.currentTimeMillis();
		print(sort(FileIntArray.FileToIntArray(filepathSort)));
		endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime) + "ms");
	}

	/**
	 * Die Methode 'sort()' stellt das uebergebene int[] fuer die Methode
	 * 'quicksort()' bereit. Liefert ein int[] zurueck.
	 * 
	 * @param array
	 * @return
	 */
	public static int[] sort(int[] array) {
		quicksort(array, 0, array.length - 1);
		return array;
	}

	/**
	 * Die Methode 'quicksort()' teilt das uebergebene Array rekursiv in
	 * Teil-Arrays. Liefert ein int[] zurueck.
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static int[] quicksort(int[] array, int left, int right) {
		if (left < right) {
			int pivot = exchange(array, left, right);
			if (pivot > left)
				quicksort(array, left, pivot - 1);
			if (pivot < right)
				quicksort(array, pivot + 1, right);
		}
		return array;
	}

	/**
	 * Die Methode 'exchange()' sortiert die Teil-Arrays und fuegt sie wieder
	 * zusammen.
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static int exchange(int[] array, int left, int right) {
		int pivot = array[((left + right) / 2)];
		if (array.length > 1) {
			while (true) {
				while (array[left] < pivot) { // Suche von links Wert groeﬂer als 'pivot'
					left++;
				}
				while (array[right] > pivot) { // Suche von rechts Wert kleiner als 'pivot'
					right--;
				}
				if (array[left] > array[right]) { // Wenn wert links groeﬂer als rechts, tausche Werte.
					int helper = array[right];
					array[right] = array[left];
					array[left] = helper;
				} else
					return left; // Gebe rechte Position zurueck
			}
		}
		return right; // Gebe linke Position zurueck
	}

	/**
	 * Die Methode 'print()* gibt ein uebergebenes Array in der Konsole aus.
	 * 
	 * @param array
	 */
	public static void print(int[] array) {
		System.out.println("\n" + "---sorted---");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}