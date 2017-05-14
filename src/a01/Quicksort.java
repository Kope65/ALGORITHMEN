package a01;

/**
 * 
 * 
 * @author s791580, s780025
 * 
 */

public class Quicksort {

	protected static int[] intArr = { 16, 2300, 14, 15, 10, 1, -5, 200, 199,
			201, -31, 3, 55, -157, -1250, 5, 6, 7, 8, 17, -17, 111, -111, 1111,
			125, 145, 159, 426, 428, 456, 441, 2356, 36365, 4575, 5698, 54447,
			451124, 1552, 45863, 25863, 15523, 565665, 2254, 5484, 121658,
			15156, 6555 };
	protected static String filepath = "C:/Users/Toni/Documents/PR2/ALGO/FileIntArrayMitBeispielen/Rand1000_1";
	protected static long startTime;
	protected static long endTime;

	public static void main(String[] args) {
		startTime = System.currentTimeMillis();
		print(sort(FileIntArray.FileToIntArray(filepath)));
		// print(sort(intArr));
		endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime) + "ms");
	}

	public static int[] sort(int[] array) {
		quicksort(array, 0, array.length - 1);
		return array;
	}

	private static int[] quicksort(int[] array, int left, int right) {
		if (left < right) {
			int pivot = divide(array, left, right);
			if (pivot > left)
				quicksort(array, left, pivot - 1);
			if (pivot < right)
				quicksort(array, pivot + 1, right);
		}
		return array;
	}

	private static int divide(int[] array, int left, int right) {
		if (array.length > 1) {
			int pivot = array[((left + right) / 2)];
			while (true) {
				while (array[left] < pivot) {
					left++;
				}
				while (array[right] > pivot) {
					right--;
				}
				if (array[left] > array[right]) {
					int helper = array[right];
					array[right] = array[left];
					array[left] = helper;
				} else
					return right;
			}
		}
		return left;
	}

	public static void print(int[] array) {
		System.out.println("\n" + "---sorted---");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}