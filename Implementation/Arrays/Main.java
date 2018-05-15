package Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println(Methods.containsDuplicatesAtK(new int[] {}, 3));
		System.out.println(Methods.containsDuplicatesAtK(new int[] {1,2}, -1));
		System.out.println(Methods.containsDuplicatesAtK(new int[] {1, 2, 3, 4, 1, 2, 3, 4}, 3));
		System.out.println(Methods.containsDuplicatesAtK(new int[] {1, 2, 3, 1, 4, 5}, 3));
		System.out.println(Methods.containsDuplicatesAtK(new int[] {1, 2, 3, 4, 5}, 3));
		System.out.println(Methods.containsDuplicatesAtK(new int[] {1, 2, 3, 4, 4}, 3));
	}
}
