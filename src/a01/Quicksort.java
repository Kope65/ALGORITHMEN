package a01;

/**
 * 
 * 
 * @author s791580, s780025
 * 
 */

public class Quicksort {

	protected static int[] intArr = { 16, 2300, 14, 15, 10, 1, 5, 200, 199, 201,
			-31, 3, 55, -157, -1250 };
	protected static String filepath = "C:/Users/Toni/Documents/PR2/ALGO/FileIntArrayMitBeispielen/Rand10_2";

	public static void main(String[] args) {
		print(sort(FileIntArray.FileToIntArray(filepath)));
		print(sort(intArr));
	}

	public static int[] sort(int[] array) {
		quicksort(array, 0, array.length - 1);
		return array;
	}

	private static int[] quicksort(int[] array, int left, int right) {
		if (left < right) {
			int pivot = divide(array, left, right);
			if (pivot > 1)
				quicksort(array, left, pivot - 1);
			if (pivot + 1 < right)
				quicksort(array, pivot + 1, right);
		}
		return array;
	}

	public static int divide(int[] array, int left, int right) {
		if (array.length > 1) {
			int pivot = array[left];
			while (true) {
				while (array[left] < pivot) {
					left++;
				}
				while (array[right] > pivot) {
					right--;
				}
				if (left < right) {
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