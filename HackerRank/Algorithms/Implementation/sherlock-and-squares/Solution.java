import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/sherlock-and-squares
public class Solution {

    public static void main(String[] args) {
        /* read input using a scanner */
        Scanner in  = new Scanner(System.in);
        int tests = in.nextInt();
        for (int test = 0; test < tests; test++) {
            /* read low limit and upper limit */
            int A = in.nextInt();
            int B = in.nextInt();
            /* find roots of both limits */
            int rootA = (int)Math.sqrt(A);
            int rootB = (int)Math.sqrt(B);
            /* find the number of perfect squares in between */
            int result = rootB-rootA;
            /* check if the low limit is also a perfect square */
            if (rootA*rootA == A)
                result++;
            /* print result to STDOUT */
            System.out.println(result);
        }
        /* close scanner */
        in.close();
    }
}