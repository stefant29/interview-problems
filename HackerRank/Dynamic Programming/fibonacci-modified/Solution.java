import java.util.*;
import java.math.*;

// https://www.hackerrank.com/challenges/fibonacci-modified
public class Solution {
    // use recursion to compute the n'th value of the modified Fibonacci
    public static BigInteger computeN_Fib(BigInteger t_ant, BigInteger t_current, int n) {
        // when the n'th element is reached, stop the recursion 
        //     and return the current value
        if (n == 0)
            return t_current;
        // compute the current element
        BigInteger newCurrent = t_ant.add(t_current.multiply(t_current));
        // return the call to the next element
        return computeN_Fib(t_current, newCurrent, n-1);
    }
    
    public static void main(String args[] ) throws Exception {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        int t0 = in.nextInt();
        int t1 = in.nextInt();
        int n  = in.nextInt();
        // write to STDOUT
        System.out.println(computeN_Fib(BigInteger.valueOf(t0), BigInteger.valueOf(t1), n-2));
        // close the scanner
        in.close();
    }
}
