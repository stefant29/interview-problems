import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/find-the-median
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
        
        /* print the middle element */
        System.out.println(arr[arr.length/2]);
        
        /* close scanner */
        in.close();
    }
}