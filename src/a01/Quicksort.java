package a01;

/**
 * 
 * 
 * @author Katharina-Sophia Bolinski s791580, Toni Kluth s780025
 * 
 */

public class Quicksort {
	/* unsortiertes Array*/ 
	protected static int[] intArr = { 16, 2300, 14, 15, 10, 1, 5, 200, 199, 201,
			-31, 3, 55, -157, -1250 };
	protected static String filepath = "C:/Users/Toni/Documents/PR2/ALGO/FileIntArrayMitBeispielen/Rand10_2";

	public static void main(String[] args) {
		print(sort(FileIntArray.FileToIntArray(filepath)));
		print(sort(intArr));
	}

	/* pivot wird gewaehlt */
	
	public static int[] sort(int[] array) {
		quicksort(array, 0, array.length - 1); //letztes Element wird als pivot verwendet
		return array;
	}

	
	/** Methode um herauszufinden welche Elemente <= und > als pivot sind
	 * und Zerlegung in Teil-Arrays
	 **/
	
	private static int[] quicksort(int[] array, int left, int right) {
		if (left < right) {
			int pivot = divide(array, left, right);
			if (pivot > 1) // wenn Element <= als pivot dann links
				quicksort(array, left, pivot - 1);
			if (pivot + 1 < right) // wenn Element > als pivot dann rechts
				quicksort(array, pivot + 1, right);
		}
		return array;
	}

	
	/** Hier werden die Teil-Arrays sortiert und wieder zusammengefügt **/
	
	public static int divide(int[] array, int left, int right) {
		if (array.length > 1) {
			int pivot = array[left];
			while (true) {
				// Suche von links Element größer pivot
				while (array[left] < pivot) { 
					left++;
				}
				// Suche von rechts Element kleiner pivot
				while (array[right] > pivot) {
					right--;
				}
				
				// Quicksort wird auf die verkleinerten Arrays angewendet und wieder zusammengesetzt
				if (left < right) {
					int helper = array[right];
					array[right] = array[left]; 
					// tausche Daten links mit Daten rechts
					array[left] = helper;
				} else
					return right;
			}
		}
		return left; // gibt die Pivot-Position zurück
	}

	public static void print(int[] array) {
		System.out.println("\n" + "---sorted---");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

