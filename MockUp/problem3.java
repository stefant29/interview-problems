import java.util.*;
import java.util.Map.Entry;

// 3. Given an array of numbers. Find out the number with odd frequency of occurrence
public class Solution {
	public static int getOddFrequency(int[] arr) throws IllegalArgumentException {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	
		if (arr == null || arr.length < 1)
			throw new IllegalArgumentException();
	
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (!hashMap.containsKey(arr[i]))
				hashMap.put(arr[i], 1);
			else
				hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
		}
	
		Iterator it = hashMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Entry<Integer, Integer>) it.next();
			if ((int)entry.getValue() % 2 != 0)
				return (int)entry.getKey();
	
		}
	
//		for (Map.Entry entry : hashMap.entrySet()) {
//			if ((int)entry.getValue() % 2 != 0)
//				return (int)entry.getKey();
//		}
//	
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 1, 2};
		System.out.println(getOddFrequency(arr));
	}
}