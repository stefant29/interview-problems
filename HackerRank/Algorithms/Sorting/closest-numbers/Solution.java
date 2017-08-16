import java.util.*;

// https://www.hackerrank.com/challenges/closest-numbers
public class Solution {

    public static void main(String[] args) {
        /* read input */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = in.nextInt();

        /* sort the initial array */
        Arrays.sort(arr);
        
        ArrayList<Integer> elements = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        /* compute the absolute difference between two adjacent elemnets */
        for (int i = 0; i < N-1; i++) {
            int crtMin = Math.abs(arr[i] - arr[i+1]);
            /* update the global minimum */
            if (min >= crtMin) {
                /* if there is new minimum, clear the previous values */
                if (min > crtMin)
                    elements.clear();
                /* update minimum */
                min = crtMin;
                /* add elements who's difference is equal to minimum */
                elements.add(arr[i]);
                elements.add(arr[i+1]);
            }
        }
        
        /* if there are no elements, print 0 */
        if (elements.size() == 0)
            System.out.println("0");
        else {
            /* sort the elements that give the smallest difference */
            Collections.sort(elements);
            /* print the elements */
            for (int i = 0; i < elements.size(); i++)
                System.out.print(elements.get(i) + " ");
        }

        /* close scanner */
        in.close();
    }
}