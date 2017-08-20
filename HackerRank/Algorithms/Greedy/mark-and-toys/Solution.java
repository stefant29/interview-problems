import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/mark-and-toys
public class Solution {

    static int maximumToys(int[] prices, int k) {
        /* 
         * greedy: sort the prices to get as many toys
         * as possible, at the lowest cost
         */
        Arrays.sort(prices);
        
        /* buy toys for $k */
        int i = 0;
        while (k > 0)
            k -= prices[i++];

        /* return the number of toys bought */
        return i-1;
    }

    public static void main(String[] args) {
        /* read input from STDIN */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] prices = new int[n];
        for(int prices_i = 0; prices_i < n; prices_i++)
            prices[prices_i] = in.nextInt();

        /* compute the maximum number of Toys Mark can buy */
        int result = maximumToys(prices, k);
        /* print the result at STDOUT */
        System.out.println(result);
        /* close scanner */
        in.close();
    }
}

