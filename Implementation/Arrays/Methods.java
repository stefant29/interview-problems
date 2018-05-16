package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Methods {
	/**
	 * Given an unsorted array that may contain duplicates. 
	 * Also given a number k which is smaller than size of array. 
	 * Write a function that returns true if array contains duplicates within k distance.
	 * https://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
	 */
	public static boolean containsDuplicatesAtK(int[] arr, int k) {
		if (k <= 0)
			return false;
		
		/** complexity: O(nk) */
		/*
		for (int i_crt = 0; i_crt < arr.length; i_crt++)
			for (int i = 1; i <= k; i++)
				if (i_crt + i < arr.length && arr[i_crt] == arr[i_crt + i])
					return true;
		*/	
		
		
		/** complexity: O(n) */
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hashSet.contains(arr[i]))
				return true;
			else
				hashSet.add(arr[i]);
			if (i-k >= 0)
				hashSet.remove(arr[i-k]);
		}
		
		return false;
	}
	
	/** https://www.geeksforgeeks.org/print-distinct-elements-given-integer-array/
	 * Given an integer array, print all distinct elements in array. 
	 * The given array may contain duplicates and the output should print every element only once. 
	 * The given array is not sorted.
	 */
	public static void printDistinctArray(int[] arr) {
		Set<Integer> set_elems = new HashSet<Integer>();
		for (int i : arr) {
			if (!set_elems.contains(i)) {
				System.out.print(i + ", ");
				set_elems.add(i);
			}
		}
		System.out.println();
	}
	
	/** https://www.geeksforgeeks.org/find-permuted-rows-given-row-matrix/
	 * We are given a m*n matrix of positive integers and a row number. 
	 * The task is to find all rows in given matrix which are permutations of given row elements. 
	 * It is also given that values in every row are distinct.
	 */
	public static void findPermutedRows(int n, int m, int[][] mat, int row) {
		Set<Integer> row_elements = new HashSet<Integer>();
		
		for (int i = 0; i < m; i++)
			row_elements.add(mat[row][i]);
		
		for (int i = 0; i < n; i++)
			if (i != row) {
				boolean good = true;
				for (int j = 0; j < m; j++)
					if (!row_elements.contains(mat[i][j])) {
						good = false;
						break;
					}
				if (good)
					System.out.println(i);
			}
	}
	public static void findPermutedRowsNotDiff(int n, int m, int[][] mat, int row) {
		
	}
	
}
