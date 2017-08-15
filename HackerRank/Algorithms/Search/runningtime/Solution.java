import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/runningtime
public class Solution {
    
    /* implementation of insertionSort */
    public static int insertionSortPart(int[] ar) {
        int count = 0;
        
        /* 
         * if the array has only one element, 
         * the array is sorted, so no shift is made
         */
        if (ar.length < 1)
            return count;

        for (int k = 1; k < ar.length; k++) {
            int val = ar[k];
            for (int i = 0; i < k; i++)
                if (ar[i] > val) {
                    for (int j = k; j > i; j--) {
                        ar[j] = ar[j-1];
                        /* count the shifts */
                        count++;
                    }
                    ar[i] = val;
                    break;
                }
        }
        return count;
    }
    
    public static void main(String[] args) {
        /* use a scanner to read the input array from STDIN */
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        /* read the array one element at a time */
        for(int i=0;i<s;i++)
            ar[i]=in.nextInt();
        
        /* print to STDOUT the number of shifts made by insertionSort */
        System.out.println(insertionSortPart(ar));
                    
    }
}
