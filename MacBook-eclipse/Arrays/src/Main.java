
public class Main {

	public static void main(String[] args) {
//		System.out.println(Methods.findPairWithSum(new int[] { 1, 2, 3, 4, 5, 6 }, 7));
//		System.out.println(Methods.checkForDuplicatesInRange(new int[] {1, 2, 3, 4, 1, 2, 3, 4}, 3));
//		System.out.println(Methods.checkForDuplicatesInRange(new int[] {1, 2, 3, 1, 4, 5}, 3));
//		System.out.println(Methods.checkForDuplicatesInRange(new int[] {1, 2, 3, 4, 5}, 3));
//		System.out.println(Methods.checkForDuplicatesInRange(new int[] {1, 2, 3, 4, 4}, 3));
		
		int[] arr1 = Methods.wchichIsSubSet(new int[] {}, new int[] {});
		Methods.printArray(arr1);
		arr1 = Methods.wchichIsSubSet(new int[] {1,2,3,4}, new int[] {5,6});
		Methods.printArray(arr1);
		arr1 = Methods.wchichIsSubSet(new int[] {1,2,3,4,5}, new int[] {1,4});
		Methods.printArray(arr1);
		arr1 = Methods.wchichIsSubSet(new int[] {1,2,5,7,3,6,21,45}, new int[] {45, 2, 5});
		Methods.printArray(arr1);
	}
}
