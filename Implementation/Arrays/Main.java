package Arrays;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		System.out.println(Methods.containsDuplicatesAtK(new int[] {}, 3));
		System.out.println(Methods.containsDuplicatesAtK(new int[] {1,2}, -1));
		System.out.println(Methods.containsDuplicatesAtK(new int[] {1, 2, 3, 4, 1, 2, 3, 4}, 3));
		System.out.println(Methods.containsDuplicatesAtK(new int[] {1, 2, 3, 1, 4, 5}, 3));
		System.out.println(Methods.containsDuplicatesAtK(new int[] {1, 2, 3, 4, 5}, 3));
		System.out.println(Methods.containsDuplicatesAtK(new int[] {1, 2, 3, 4, 4}, 3));
		System.out.println("============");
		
		Methods.printDistinctArray(new int[] {12, 10, 9, 45, 2, 10, 10, 45});
		Methods.printDistinctArray(new int[] {1, 2, 3, 4, 5});
		Methods.printDistinctArray(new int[] {1, 1, 1, 1, 1});
		Methods.printDistinctArray(new int[] {6, 10, 5, 4, 9, 120, 4, 6, 10});
		Methods.printDistinctArray(new int[] {10, 5, 3, 4, 3, 5, 6});
		System.out.println("============");
		
		int mat[][] = {{3, 1, 4, 2},
                		{1, 6, 9, 3},
                		{1, 2, 3, 4},
                		{4, 3, 2, 1}};
		Methods.findPermutedRows(4, 4, mat, 3);
		System.out.println("============");
		
		
		
		int mat1[][] = {{3, 1, 4, 2},
        		{1, 6, 9, 3},
        		{1, 2, 1, 4},
        		{4, 1, 2, 1}};
		Methods.findPermutedRowsNotDiff(4, 4, mat, 3);
		System.out.println("============");
		Methods.findPermutedRowsNotDiff(4, 4, mat1, 3);
		System.out.println("============");
		
		Methods.findSymetricPairs(new int[][] {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}});
		System.out.println("------------");
		Methods.findSymetricPairs(new int[][] {{1,2}});
		System.out.println("============");
		
		
		Methods.printArr(Methods.findMissingInRange(new int[]{10, 12, 11, 15}, 10, 15));
		System.out.println("------------");
		Methods.printArr(Methods.findMissingInRange(new int[]{1, 14, 11, 51, 15}, 50, 55));
		System.out.println("============");
		
		Methods.printArr(Methods.reduceArray(new int[] {10, 40, 20}));
		System.out.println("------------");
		Methods.printArr(Methods.reduceArray(new int[] {5, 10, 40, 30, 20}));
		System.out.println("============");
		
		
		System.out.println(Methods.distinctSets(new int[] {12, 34, 11, 9, 3}, new int[] {2, 1, 3, 5}));
		System.out.println(Methods.distinctSets(new int[] {12, 34, 11, 9, 3}, new int[] {7, 2, 1, 5}));
		System.out.println("============");
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Chennai", "Banglore");
		map.put("Bombay", "Delhi");
		map.put("Goa", "Chennai");
		map.put("Delhi", "Goa");
		Methods.printItinerary(map);
		System.out.println("============");

		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("A", "C");
		map2.put("B", "C");
		map2.put("C", "F");
		map2.put("D", "E");
		map2.put("E", "F");
		map2.put("F", "F");
		System.out.println(Methods.getNoEmployees(map2));
		System.out.println("============");
		
		
		int arr2[] = { 92, 75, 65, 48, 45, 35 };
        int k = 10;
        boolean ans = Methods.pairSumDivK(arr2, k);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
        System.out.println("============");
        
        
        int arr3[] = {3, 4, 7, 1, 2, 9, 8};
        System.out.println(Methods.findSumFourElem(arr3));
        System.out.println("============");

        System.out.println(Methods.largestSubarraySumZero(new int[] {15, -2, 2, -8, 1, 7, 10, 23}));
        System.out.println(Methods.largestSubarraySumZero(new int[] {1, 2, 3}));
        System.out.println(Methods.largestSubarraySumZero(new int[] {1, 0, 3}));
        System.out.println("============");
        
        System.out.println(Methods.longestConsecutiveSubsequence(new int[] {1, 9, 3, 10, 4, 20, 2}));
        System.out.println(Methods.longestConsecutiveSubsequence(new int[] {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}));
        System.out.println("============");
        
        Methods.countDistinctInWindowK(new int[]  {1, 2, 1, 3, 4, 2, 3}, 4);
        System.out.println("============");
        
        Methods.ConstDS constDS = new Methods.ConstDS();
        constDS.instert(1);
        System.out.println(constDS);
        constDS.instert(2);
        System.out.println(constDS);
        constDS.instert(3);
        System.out.println(constDS);
        constDS.instert(4);
        System.out.println(constDS);
        constDS.instert(1);
        System.out.println(constDS);
        constDS.instert(5);
        System.out.println(constDS);
        constDS.instert(6);
        System.out.println(constDS);
        constDS.instert(7);
        System.out.println(constDS);
        constDS.remove(3);
        System.out.println(constDS);
        System.out.println("random: " + constDS.getRandom());
        System.out.println("random: " + constDS.getRandom());
        System.out.println("random: " + constDS.getRandom());
        System.out.println("search: " + constDS.search(1));
        System.out.println("search: " + constDS.search(10));
        System.out.println("search: " + constDS.search(53));
        System.out.println("search: " + constDS.search(-1));
        System.out.println("============");
        
        
//        System.out.println(Methods.largestContiguosSubarray(new int[] {20, 22, 21, 10, 12, 14, 11, 13}));
        System.out.println(Methods.largestContiguosSubarray(new int[] {12, 4, 56, 8, 10, 11, 13, 14}));
//        System.out.println(Methods.largestContiguosSubarray(new int[] {14, 12, 11, 20}));
//        System.out.println(Methods.largestContiguosSubarray(new int[] {1, 56, 58, 57, 90, 92, 94, 93, 91, 45}));
        
//        System.out.println("============");
//        System.out.println("============");

	}
}
