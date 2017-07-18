import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/marcs-cakewalk
public class Solution {
   
    public static void main(String[] args) {
        // use scanner to read input from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calories = new int[n];
        for(int calories_i=0; calories_i < n; calories_i++)
            calories[calories_i] = in.nextInt();
        
        // sort the array for a greedy approach
        Arrays.sort(calories);
        
        // must use LONG
        long sum = 0;
        // compute the number of miles he needs to run for each step
        for(int calories_i=n-1; calories_i >= 0; calories_i--)
        	sum = (long) (sum + calories[calories_i] * Math.pow(2, n-calories_i-1)); 
        
        // print the result to STDOUT
        System.out.println(sum);
        
        // close scanner
        in.close();
    }
}
