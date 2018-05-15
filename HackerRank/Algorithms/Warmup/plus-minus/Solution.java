import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/plus-minus
public class Solution {

    public static void printFractions(int count, int n) {
        /* avoid division by zero */
        if (count != 0)
            /* print the fraction */
            System.out.println((float) count / n);
        /* if count is 0, print 0 */
        else
            System.out.println("0");
    }

    public static void main(String[] args) {
        /* read input */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int poz = 0, neg = 0, zero = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            /* count the positive numbers */
            if (arr[arr_i] > 0)
                ++ poz;
            /* count the negative numbers */
            else if (arr[arr_i] < 0)
                ++ neg;
            /* count the zeros in the array */
            else 
                ++ zero;
        }

        /* print the fractions */
        printFractions(poz, n);
        printFractions(neg, n);
        printFractions(zero, n);

        /* close scanner */
        in.close();
    }
}
