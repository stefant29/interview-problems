
public class Main {

	public static void main(String[] args) {
		System.out.println(Methods.findPairWithSum(new int[] { 1, 2, 3, 4, 5, 6 }, 7));
		System.out.println(Methods.checkForDuplicatesInRange(new int[] {1, 2, 3, 4, 1, 2, 3, 4}, 3));
		System.out.println(Methods.checkForDuplicatesInRange(new int[] {1, 2, 3, 1, 4, 5}, 3));
		System.out.println(Methods.checkForDuplicatesInRange(new int[] {1, 2, 3, 4, 5}, 3));
		System.out.println(Methods.checkForDuplicatesInRange(new int[] {1, 2, 3, 4, 4}, 3));
	}
}
