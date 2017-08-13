import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-bitwise-and
public class Solution {

    public static void main(String[] args) {
        /* reda input from STDIN using scanner */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        /* for each test case */
        for(int a0 = 0; a0 < t; a0++){
            /* read input */
            int n = in.nextInt();
            int k = in.nextInt();
            int max = Integer.MIN_VALUE;
            /* apply bit operator on each 2 consecutive numbers */
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j <= n; j++) {
                    int and = i & j;
                    /* check if the result matches the restrictions */
                    if (and < k && and > max)
                        /* store the new result if it is bigger */
                        max = and;
                }
            }
            /* print the biggest AND operation */
            System.out.println(max);
        }
    }
}