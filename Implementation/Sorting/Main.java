package implementation;

public class Main {
	
	/** 
	 * find the index of the bigest element in the array, 
	 *	starting from a given index
	 */
	public static int findMaxIndex(int[] arr, int start) {
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = start; i < arr.length; i++)
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		return index;
	}
	
	/** 
	 * find the index of the smallest element in the array, 
	 *	starting from a given index
	 */
	public static int findMinIndex(int[] arr, int start) {
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int i = start; i < arr.length; i++)
			if (arr[i] < min) {
				min = arr[i];
				index = i;
			}
		return index;
	}
	
	/** 
	 * implementation of selection sort;
	 * 	sorts the array in an increasing order
	 */
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = findMinIndex(arr, i);
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	
	/** 
	 * nice display for an array
	 */
	public static void printArr(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length-1; i++)
				System.out.print(arr[i] + ", ");
		System.out.println(arr[arr.length-1] + "]");
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 3, 5, 4, 7, 8, 9};
		// print the array before the sorting
		printArr(arr);
		// use selection sort to sort the array
		selectionSort(arr);
		// print the array after the sorting
		printArr(arr);
	}
}
