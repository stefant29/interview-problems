import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/diagonal-difference
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        int dp = 0;
        int ds = 0;
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
                /* compute the sum of the first diagonal */
                if (a_i == a_j)
                    dp += a[a_i][a_j];
                /* compute the sum of the second diagonal */
                if (a_i + a_j + 1 == n)
                    ds += a[a_i][a_j];
            }
        }
        /* print the absolute difference between the two diagonals */
        System.out.println(Math.abs(ds-dp));
        /* close scanner */
        in.close();
    }
}
