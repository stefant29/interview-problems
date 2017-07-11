import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/birthday-cake-candles
public class Solution {

    public static void main(String[] args) {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        int maxLength = Integer.MIN_VALUE;
        int count = 0;
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
            // find the biggest number
            if (ar[ar_i] > maxLength) {
                maxLength = ar[ar_i];
                // reset the counter to 1
                count = 1;
            // update the counter if the biggest number is found again
            } else if (ar[ar_i] == maxLength)
                count++;
        }
        // print to STDOUT the number of candles blown
        System.out.println(count);
        // close the scanner
        in.close();
    }
}
