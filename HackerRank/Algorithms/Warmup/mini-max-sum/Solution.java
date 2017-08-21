import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/mini-max-sum
public class Solution {

    public static void main(String[] args) {
        /* read input */
        Scanner in = new Scanner(System.in);
        long[] arr = new long[5];
        long sum = 0;
        for(int i = 0; i < 5; i++){
            arr[i] = in.nextLong();
            sum += arr[i];
        }
        
        /* sort the array to get the minimum and the maximum values */
        Arrays.sort(arr);
        /* extract the minimum and the maximum */
        long min = arr[0], max = arr[arr.length-1];
        
        System.out.println((sum - max) + " " + (sum - min));
        
        /* close scanner */
        in.close();
    }
}
