import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/crush
public class Solution {
/*
// examples: 
        1 6 100
        2 3 200

    answer:    100 300 300  100 100 100    
    
    my_answer: 100 200   0  -200   0   0  -100
               100 300 300   100 100 100     0


//  example 2:
        1 3 100
        2 3 100
        4 5 100
        3 4 100

    answer: 100 200 300 200 100

    my_answer: 100 100 100 0 0     -100
               100 200 300 300 300 0

//  example 3:
        5 3
        1 2 100
        2 5 100
        3 4 100
        
answer: 100 200 200 200 100
   
   
   
    my_answer: 100 100 100   0 100 -100  
               100 200 200 200 100    0
*/

    public static void main(String[] args) {
        // read input from STDIN
        Scanner in = new Scanner(System.in);
        // read n & m
        int n = in.nextInt(), m = in.nextInt();
        // use an array with n+1 elements (n+1'th element is to limit the n'th element)
        long[] ar = new long[n+1];
        // read inputs
        for (int op = 0; op < m; op++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            int k = in.nextInt();
            // add to the element at index a the number k
            ar[a] += k;
            // substract from the element at index b+1 the number k
            ar[b+1] -= k;
        }

        // max is the biggest number
        long max = Long.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            // add the value from left
            ar[i] += ar[i-1];
            // update the maximum
            if (ar[i] > max)
                max = ar[i];
        }
        // print to STDOUT the maximum value
        System.out.println(max);
        
        // close scanner
        in.close();
    }
}
