import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-running-time-and-complexity
public class Solution {
    /* find if a number is prime */
    public static String isPrime(int number) {
        /* if the number is 0 or 1, it cannot be considered prime */
        if (number == 1 || number == 0)
            return "Not prime";
  
        /*
         * go through each number from 1 to number/2 and find if the number 
         * is divisible with it. If it is, then return "not prime"
         */
        for (int i = 2; i <= number / 2; i++)
            if (number % i == 0) 
                return "Not prime";
        
        /* if there is no number that divide "number", then return "Prime" */
        return "Prime";
    }

    public static void main(String[] args) {
        /* use scanner to get the input from STDIN */
        Scanner in = new Scanner(System.in);
        int noOfTests = in.nextInt();
        for (int i = 0; i < noOfTests; i++) {
            int n = in.nextInt();
            /* find if the number is prime or not */
            String result = isPrime(n);
            /* print to stdout the result */
            System.out.println(result);
        }
        /* close scanner */
        in.close();
    }
}

