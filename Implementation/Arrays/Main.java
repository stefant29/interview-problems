package Arrays;

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
	}
}
