package Arrays;

import java.util.HashSet;

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
}
