import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
public class Solution {

    static int minimumAbsoluteDifference(int n, int[] arr) {
        /* 
         * greedy aproach: sort the array for the elements to have
         *   the difference as small as possible between them
         */
        Arrays.sort(arr);
        int len = arr.length-1;
        int min = Integer.MAX_VALUE;
        /* 
         * find the minimum difference by computing and comparing
         * the differences between each two adjacent elements
         */
        for (int i = 0; i < len; i++) {
            int crtDif = Math.abs(arr[i] - arr[i+1]);
            if (crtDif < min)
                min = crtDif;
        }
        /* return the minimum difference */
        return min;
    }

    public static void main(String[] args) {
        /* read input: n and the array of integers */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++)
            arr[arr_i] = in.nextInt();
        /* compute the minimum absolute difference in the array */
        int result = minimumAbsoluteDifference(n, arr);
        /* print the result to STDOUT */
        System.out.println(result);
        /* close the scanner */
        in.close();
    }
}

