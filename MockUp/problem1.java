import java.util.HashSet;

// 1. Find target sum elements in array.

// array of ints
// return a boolean: true or false if the array contains elements that sum up to the target
// check: if array.size < 2 return false
// pairs should contain different elements

// ex: 1   target = 4
// DS: 

// crt step: search crt value in the aux DS; if (!exists) add target-crt_value; else return true;


public class Solution {

	public static boolean existsPair(int[] arr, int target) {
		HashSet<Integer> set = new HashSet<Integer>();
		int len;

		// sanity checks
		if (arr == null)
			return false;
		
		len = arr.length;

		for (int i = 0; i < len; i++)
			if (set.contains(arr[i]))
				return true;
			else
				set.add(target - arr[i]);

		return false;
	}

	public static void main(String[] args) {
		int[] arr = null;
		System.out.println(existsPair(arr, 4));
	}
}