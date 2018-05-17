package Arrays;

import java.util.HashMap;
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
	/** Extend the above solution to work for input matrix where all elements of a row don’t have be distinct.
	 */
	public static void findPermutedRowsNotDiff(int n, int m, int[][] mat, int row) {
		HashMap<Integer, Integer> row_elements = new HashMap<Integer, Integer>();
		for (int i = 0; i < m; i++)
			if (row_elements.containsKey(mat[row][i]))
				row_elements.put(mat[row][i], row_elements.get(mat[row][i])+1);
			else
				row_elements.put(mat[row][i], 1);
		System.out.println(row_elements);
		for (int i = 0; i < m; i++) {
			if (i != row) {
				boolean good = true;
				HashMap<Integer, Integer> row_elements_copy = (HashMap<Integer, Integer>) row_elements.clone();
				for (int j = 0; j < m; j++)
					if (!row_elements_copy.containsKey(mat[i][j])) {
						good = false;
						break;
					} else {
						if (row_elements_copy.get(mat[i][j]) == 1)
							row_elements_copy.remove(mat[i][j]);
						else
							row_elements_copy.replace(mat[i][j], row_elements_copy.get(mat[i][j])-1);
					}
				if (good)
					System.out.println(i);
			}
		}
	}
	
	
	
	/** https://www.geeksforgeeks.org/given-an-array-of-pairs-find-all-symmetric-pairs-in-it/
	 * Two pairs (a, b) and (c, d) are said to be symmetric if c is equal to b and a is equal to d. 
	 * For example (10, 20) and (20, 10) are symmetric. 
	 * Given an array of pairs find all symmetric pairs in it.
	 */
	public static void findSymetricPairs(int[][] pairs) {
		/** Complexity: O(n^2)
		 * Simple, doubly looped search through pairs */
		/*
		for (int i = 0; i < pairs.length-1; i++) {
			int first = pairs[i][0];
			int second = pairs[i][1];
			for (int j = i+1; j < pairs.length; j++)
				if (first == pairs[j][1] && second == pairs[j][0]) {
					System.out.println("("+first+","+second+")");
					break;
				}
		}
		*/
		
		/** Complexity: O(n)
		 * Search reversed pairs in a hashmap.
		 * If exists, print them; if not, add pairs to the hashmap */
		HashMap<Integer, Integer> map_pairs = new HashMap<Integer, Integer>();
		for (int i = 0; i < pairs.length; i++) {
			int first = pairs[i][0];
			int second = pairs[i][1];
			if (map_pairs.containsKey(first) 
					&& map_pairs.get(first) == second)
				System.out.println("("+first+","+second+")");
			else
				map_pairs.put(second, first);	
		}
		
		
	}
	
}
