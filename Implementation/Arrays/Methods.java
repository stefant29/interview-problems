package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
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
	/** Extend the above solution to work for input matrix where all elements of a row donï¿½t have be distinct.
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
	
	
	/** https://www.geeksforgeeks.org/find-missing-elements-of-a-range/
	 * Given an array arr[0..n-1] of distinct elements and a range [low, high], 
	 * find all numbers that are in range, but not in array. 
	 * The missing elements should be printed in sorted order.
	 */
	public static int[] findMissingInRange(int[] arr, int lo, int hi) {
		Set<Integer> set_elements = new HashSet<Integer>();
		ArrayList<Integer> missing_elements = new ArrayList<Integer>();
		
		/* construct a set with elements from arr for constant time access */
		for (int i : arr)
			set_elements.add(i);
		
		/* in the range lo->hi, add to an arrayList all elements who are missing */
		for (int i = lo; i < hi; i++)
			if(!set_elements.contains(i))
				missing_elements.add(i);
		
		/* construct the array result */
		int[] missing_elements_arr = new int[missing_elements.size()];
		for (int i = 0; i < missing_elements.size(); i++)
			missing_elements_arr[i] = missing_elements.get(i);
		
		return missing_elements_arr;
	}
	
	/** https://www.geeksforgeeks.org/convert-an-array-to-reduced-form-set-1-simple-and-hashing/
	 * Given an array with n distinct elements, convert the given array to a form 
	 * where all elements are in range from 0 to n-1. The order of elements is same, 
	 * i.e., 0 is placed in place of smallest element, 
	 * 1 is placed for second smallest element, 
	 * ï¿½ n-1 is placed for largest element.
	 */
	public static int[] reduceArray(int[] arr) {
		int[] new_arr = new int[arr.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++)
			map.put(arr[i], i);
	
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++)
			new_arr[map.get(arr[i])] = i;
		
		return new_arr;
	}
	
	/** https://www.geeksforgeeks.org/check-two-given-sets-disjoint/
	 * Given two sets represented by two arrays, 
	 * how to check if the given two sets are disjoint or not? 
	 * It may be assumed that the given arrays have no duplicates.
	 */
	public static Boolean distinctSets(int[] arr1, int[] arr2) {
		/*
		// O(N^2)
		// for each element in the first array
		for (int i : arr1)
			// search if there is an equal element in the second array 
			for (int j : arr2)
				// equal elements => not disjoint
				if (i == j)
					return false;
		return true;
		*/
		
		/*
		// O(N) + O(N)
		Set<Integer> arr1_set = new HashSet<Integer>();
		for (int i = 0; i < arr1.length; i++)
			arr1_set.add(arr1[i]);
		
		for (int i = 0; i < arr2.length; i++)
			if (arr1_set.contains(arr2[i]))
				return false;
		return true;
		*/
		
		// O(max(n,m))
		Set<Integer> set = new HashSet<Integer>();
		int i = 0;
		while (i < arr1.length && i < arr2.length) {
			if (!set.add(arr1[i]) || !set.add(arr2[i]))
				return false;
			i++;
		}
		while (i < arr1.length)
			if (!set.add(arr1[i++]))
				return false;
		while (i < arr2.length)
			if (!set.add(arr2[i++]))
				return false;
		return true;
	}
	
	
	/** https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
	 * Given a list of tickets, find itinerary in order using the given list. 
	 */
	public static void printItinerary(HashMap<String, String> map) {
		Map<String, String> rev_map = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : map.entrySet())
			rev_map.put(entry.getValue(), entry.getKey());
		
		String start = null;
		
		// find starting point: city with no "in" arrow: city who is only key, not value
		for (Map.Entry<String, String> entry : map.entrySet()) 
			if (!rev_map.containsKey(entry.getKey())) {
				start = entry.getKey();
				break;
			}
		
		while (map.containsKey(start)) {
			String next_city = map.get(start);
			System.out.println(start + " -> " + next_city);
			start = next_city;
		}
	}
	
	public static void printArr(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length-1; i++)
			System.out.print(arr[i] + ", ");
		if (arr.length > 0)
			System.out.println(arr[arr.length-1] + "]");
		else
			System.out.println("]");
	}

	/** https://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
	 * Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below.
		{ "A", "C" },
		{ "B", "C" },
		{ "C", "F" },
		{ "D", "E" },
		{ "E", "F" },
		{ "F", "F" } 
		
		In this example C is manager of A, C is also manager of B, F is manager of C and so on.
		Write a function to get no of employees under each manager in the hierarchy not just their direct reports. 
		It may be assumed that an employee directly reports to only one manager. 
		In the above dictionary the root node/ceo is listed as reporting to himself.
		
		Output should be a Dictionary that contains following.
		A - 0  
		B - 0
		C - 2
		D - 0
		E - 1
		F - 5 
	 */
	public static HashMap<String, Integer> getNoEmployees(HashMap<String, String> map2) {
		/*
		HashMap<String, Set<String>> managers = new HashMap<String, Set<String>>();
		String boss = null;
		for (Map.Entry<String, String> entry : map2.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (key.equals(value)) {
				boss = key;
				continue;
			}
			Set<String> set;
			if (managers.containsKey(value))
				set = managers.get(value);
			else
				set = new HashSet<String>();
			set.add(key);
			managers.put(value, set);
		}
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for (Map.Entry<String, String> entry : map2.entrySet()) {
			Stack<String> employees = new Stack<String>();
			int i = 0;
			employees.push(entry.getKey());
			while (!employees.isEmpty()) {
				String crt = employees.pop();
				if (managers.containsKey(crt))
					for (String employee : managers.get(crt))
						employees.push(employee);
				i++;
			}
			result.put(entry.getKey(), i-1);
		}
		
		return result;
		*/
		
		// O(N)
		HashMap<String, Integer> managers = new HashMap<String, Integer>();
		for (Map.Entry<String, String> entry : map2.entrySet()) {
			String employee = entry.getKey();
			String manager = entry.getValue();
			if (employee.equals(manager))
				continue;
			// add employee to list
			if (!managers.containsKey(employee))
				managers.put(employee, 0);
			// get the previous number of employees for the current manager
			int prev_no_manager = 0;
			if (managers.containsKey(manager))
				prev_no_manager = managers.get(manager);
			managers.put(manager, prev_no_manager + managers.get(employee) + 1);
		}
		return managers;
	}
	
	
	
	/** https://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
	 * Given an array of integers and a number k, write a function that returns true if given array can be divided 
	 * into pairs such that sum of every pair is divisible by k.
	 */
	public static boolean pairSumDivK(int[] arr, int k) {
		// pairs of two elements must exist
		if (arr.length % 2 == 1)
			return false;
		
		// create table with rests
		Hashtable<Integer, Integer> rests = new Hashtable<Integer, Integer>();
		for (int i : arr) {
			int rest = i % k;
			if (rests.containsKey(rest))
				rests.replace(rest, rests.get(rest)+1);
			else
				rests.put(rest, 1);
		}
		
		for (int i : arr) {
			int rest = i % k;
			// if rest splits k in half
			if (rest * 2 == k) {
				// there must be at least two elements (even number) that sum up to k
				if (rests.get(rest) % 2 == 1)
					return false;
			// if rest is 0
			} else if (rest == 0) {
				// there must be at least two elements (even number) that have rest = 0
				if (rests.get(rest) % 2 == 1)
					return false;
			// else, rest must be equal for both rest and k-rest
			} else if (rests.get(rest) != rests.get(k-rest))
				return false;
		}
		
		return true;
	}
	
	/** https://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
	 * 
	 */
	public static boolean findSumFourElem(int[] arr) {
		HashMap<Integer, Pair> sum = new HashMap<Integer, Pair>();
		for (int i = 0; i < arr.length-1; i++)
			for (int j = i+1; j < arr.length; j++) {
				int crt_sum = arr[i] + arr[j];
				if (sum.containsKey(crt_sum)) {
					System.out.println(sum.get(crt_sum) + " = " + arr[i] + " + " + arr[j]);
					return true;
				}
				sum.put(crt_sum, new Pair<Integer>(arr[i], arr[j]));
			}
		
		
		
		return false;
	}
	
	/** https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
	 * Given an array of integers, find length of the largest subarray with sum equals to 0. 
	 * Solution: create a hashMap and store as key the sums of all elements from 0 to i,
	 * 		and values, the index.
	 * 		If a sum was previously added to the hashMap, then some elements summed up to 0
	 * 		and we subtract the index of previous sum from current index to find the length
	 * 		of the largest subarray.
	 */
	public static int largestSubarraySumZero(int[] arr) {
		int sum = 0;
		int max_len = 0;
		HashMap<Integer, Integer> sum_index = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			if (sum == 0)
				max_len = i + 1;
			
			if (sum_index.containsKey(sum))
				max_len = Math.max(max_len, i-sum_index.get(sum));
			else
				sum_index.put(sum, i);
		}
		return max_len;
	}
	
	/** https://www.geeksforgeeks.org/longest-consecutive-subsequence/
	 * Given an array of integers, find the length of the longest sub-sequence
	 * such that elements in the subsequence are consecutive integers, 
	 * the consecutive numbers can be in any order.
	 */
	public static int longestConsecutiveSubsequence(int[] arr) {
		// O(NlogN): 1. sort the array 
		// 			 2. and find the longest subsequence of consecutive numbers
		/*
		Arrays.sort(arr);
		int longest_streak = 0;
		for (int i = 0; i < arr.length-1; i++) {
			int crt_streak = 1;
			while (i < arr.length && arr[i+1]==arr[i] + 1) {
				crt_streak++;
				i++;
			}
			if (crt_streak != 1) {
				if (longest_streak < crt_streak)
					longest_streak = crt_streak;
				i--;
			}
		}
		
		return longest_streak;
		*/
		
		// O(N): 1. Add all elements into a set, for fast access
		//		 2. For every element in the set, if there is no element smaller (by 1)
		//			find all elements consecutive starting with crt elements.
		int longest_streak = 0;
		Set<Integer> arr_set = new HashSet<Integer>();
		for (int i : arr)
			arr_set.add(i);
		
		for (int crt_el : arr_set)
			if (!arr_set.contains(crt_el-1)) {
				int crt_streak = 0;
				while (arr_set.contains(crt_el++))
					crt_streak++;
				if (longest_streak < crt_streak)
					longest_streak = crt_streak;
			}
		
		return longest_streak;
	}
	
	
	/** https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
	 * Given an array of size n and an integer k, 
	 * return the of count of distinct numbers in all windows of size k.
	 */
	public static void countDistinctInWindowK(int[] arr, int k) {
		if (k > arr.length)
			return;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int distinct_elems = 0;
		for (int i = 0; i < k; i++) {
			if (!map.containsKey(arr[i])) {
				distinct_elems++;
				map.put(arr[i], 1);
			} else
				map.put(arr[i], map.get(arr[i])+1);
		}
		
		// print solution
		for (int j = 0; j < k; j++)
			System.out.print(arr[j] + ", ");
		System.out.println("\t- " + distinct_elems);

		for (int i = 1; i <= arr.length - k; i++) {
			// removing elements arr[i-1]
			if (map.get(arr[i-1])>1)
				map.replace(arr[i-1], map.get(arr[i-1])-1);
			else {
				map.remove(arr[i-1]);
				distinct_elems--;
			}
			
			// adding crt element
			if (map.containsKey(arr[i+k-1]))
				map.replace(arr[i+k-1], map.get(arr[i+k-1])+1);
			else {
				map.put(arr[i+k-1], 1);
				distinct_elems++;
			}
			
			// print solution
			for (int j = i; j < i + k; j++)
				System.out.print(arr[j] + ", ");
			System.out.println("\t- " + distinct_elems);
		}
	}
	
	
	/** https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
	 * Design a data structure that supports following operations in Θ(1) time.
		insert(x): Inserts an item x to the data structure if not already present.
		remove(x): Removes an item x from the data structure if present.
		search(x): Searches an item x in the data structure.
		getRandom(): Returns a random element from current set of elements
	*/
	public static class ConstDS {
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = 0;
		
		public void instert(int x) {
			if (map.containsKey(x))
				return;
			list.add(len, x);
			map.put(x, len);
			len++;
		}
		
		public boolean remove(int x) {
			if (!map.containsKey(x))
				return false;
			
			// swap x with last element in list
			int last = list.get(len-1);
			list.set(map.get(x), last);
			list.set(len-1, x);
			// remove x from list in O(1)
			list.remove(len-1);

			// update index of last element in map
			map.replace(last, map.get(x));
			// remove x from map
			map.remove(x);

			len--;
			
			return true;
		}
		
		public boolean search(int x) {
			return map.containsKey(x);
		}
		
		public int getRandom() {
			return list.get(new Random().nextInt(list.size()));
		}
		
		@Override
		public String toString() {
			return list.toString();
		}
	}
	


	static class Pair<T> {
		T a,b;
		public Pair(T a, T b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
	 		return "(" + a + ", " + b + ")";
		}
	}

	/** https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
	 * Given an array of distinct integers, 
	 *  find length of the longest subarray which contains numbers
	 *  that can be arranged in a continuous sequence.
	 */
	public static int largestContiguosSubarray(int[] arr) {
		PairInt[] arr_pair = new PairInt[arr.length];
		// store elements into array of pairs: <elem, index>
		for (int i = 0; i < arr.length; i++)
			arr_pair[i] = new PairInt(arr[i], i);
		// sort by elems
		Arrays.sort(arr_pair, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				int o1a = ((PairInt) o1).a;
				int o2a = ((PairInt) o2).a;
				return o1a > o2a ? 1 : o1a == o2a ? 0 : -1;
			}
		});

		// find largest subsequence: for every element
		int largestSequence = 0;
		for (int i = 0; i < arr_pair.length-1; i++) {
			int j = i;
			int sum = arr_pair[i].b;
			// find the consecutive 
			while (j+1 < arr_pair.length && arr_pair[j].a + 1 == arr_pair[j+1].a) {
				int diff = j-i+1;
				sum += arr_pair[j+1].b;
				float ma = 1.0f * sum / (diff+1);
				if (ma == arr_pair[i].b + diff * 0.5 || ma == arr_pair[i].b - diff * 0.5)
					largestSequence = Math.max(largestSequence, diff+1);
				j++;
			}
			if (sum != arr_pair[i].b)
				i = j;
		}
			
		return largestSequence;
	}
	
	public static int largestContiguosSubarray2(int[] arr) {
		int largestSequence = 0;
		for (int i = 0; i < arr.length-1; i++) {
			int min_el = arr[i];
			int max_el = arr[i];

			for (int j = i+1; j < arr.length; j++) {
				// update max element in crt subarray
				if (arr[j] > max_el)
					max_el = arr[j];
				// update min element in crt subarray
				if (arr[j] < min_el)
					min_el = arr[j];
				// update largest sequence
				if (max_el - min_el == j-i)
					largestSequence = Math.max(largestSequence, j-i+1);
			}
		}
		
		return largestSequence;	
	}

	/** https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
	 * Given an array of positive and negative numbers, 
	 * find if there is a subarray (of size at-least one) with 0 sum.
	 */
	public static boolean containsSubarraySum0(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		// store all sums into a set
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			if (sum == 0)
				return true;
			
			// if sum already present in the set, then some elements reduced one another
			// -> they sum up to zero -> return true
			if (set.add(sum) == false)
				return true;
		}
		
		// there is no subarray which sum up to zero
		return false;
	}
	
	
	/** https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
	 * Given an array, print all subarrays in the array which has sum 0.
	 */
	public static void printSubarraysSum0(int[] arr) {
		HashMap<Integer, Integer> map_elem = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0) {
				for (int j = 0; j <= i; j++) 
					System.out.print(arr[j] + ", ");
				System.out.println();
			}
			
			if (map_elem.containsKey(sum)) {
				for (int j = map_elem.get(sum)+1; j <= i; j++)
					System.out.print(arr[j] + ", ");
				System.out.println();
			}
			map_elem.put(sum,  i);
		}
	}
}
