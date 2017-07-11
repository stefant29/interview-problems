import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/jumping-on-the-clouds
public class Solution {
    public static int jump(int currentPosition, int[] c, int n) {
        // return -1 (bad values) for thunderclouds
        //    and for index that exceeds the limit
        if (currentPosition >= n)
            return -1;
        if (c[currentPosition] == 1)
            return -1;
        // return 0 if the current position is the desired cloud (n-1)
        if (currentPosition == n-1)
            return 0;
        
        int step1 = jump(currentPosition + 1, c, n);
        int step2 = jump(currentPosition + 2, c, n);
        
        // if one call returns -1, then return the other value,
        //    in other words, the bigger number
        if (step1 + step2 == Math.max(step1, step2) - 1)
            return Math.max(step1, step2) + 1;
        else
            // otherwise, both being > 0 (good values), 
            //    return the smallest number and add one
            //    for current step
            return Math.min(step1, step2) + 1;
    }

    public static void main(String[] args) {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++)
            c[c_i] = in.nextInt();

        // write result to STDOUT
        System.out.println(jump(0, c, n));
        
        // close scanner
        in.close();
    }
}
