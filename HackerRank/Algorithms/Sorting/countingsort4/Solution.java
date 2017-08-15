import java.util.*;

// https://www.hackerrank.com/challenges/countingsort4
public class Solution {

	public static void main(String[] args) {
		/* read input from STDIN using Scanner */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] count = new int[100];
		int[] numbers = new int[n];
		String[] strings = new String[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = in.nextInt();
			if (i < n / 2) {
				strings[i] = "-";
				in.next();
			} else
				strings[i] = in.next();
			/* increment the times the current number appears */
			count[numbers[i]]++;
		}

        /* take each number from 0 to 100 */
		for (int i = 0; i < 100; i++) {
            int last = 0;
            /* as many times it repeats in the given numbers array */
			for (int j = 0; j < count[i]; j++)
                /* 
                 * search the array for elements that are equal 
                 * to the selected number from 0 to 100
                 */
				for (; last < n; last++)
                    /* if the number is good */
					if (i == numbers[last]) {
                        /* print the coresponding string */ 
						System.out.print(strings[last] + " ");
                        /* advance to the next position */
						last++;
						break;
					}
        }

		/* close the scanner */
		in.close();
	}
}