import java.util.*;

// https://www.hackerrank.com/challenges/java-negative-subarray
public class Solution {

    public static void main(String[] args) {
        /* read input */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        
        int noArraysNegSum = 0;
        /* try subarrays of length equal to "noElem+1": 1,2,3...n */
        for (int noElem = 0; noElem < n; noElem++)
            /* start computing the sum from 0,1..n-noElems */
            for (int pos = 0; pos < n-noElem; pos++) {
                int sum = arr[pos];
                /* compute the sum of all the "noElems" elements in the subarray */
                for (int i = pos+1; i < pos+noElem+1; i++)
                    sum += arr[i];
                /* if sum is negative, increment counter */
                if (sum < 0) 
                    noArraysNegSum++;
            }

        /* print to stdout the number of negative subarrays */
        System.out.println(noArraysNegSum);

        /* close scanner */
        in.close();
    }
}