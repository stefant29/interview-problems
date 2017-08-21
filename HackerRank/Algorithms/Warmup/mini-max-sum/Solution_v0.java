import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/mini-max-sum
public class Solution {
    
    public static long greater(long a, long b) {
        if (a > b)
            return a;
        return b;
    }
    
    public static long smaller(long a, long b) {
        if (a < b)
            return a;
        return b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        
        long max = -1;
        long min = Long.MAX_VALUE;
        max = greater(a,max);
        max = greater(b,max);
        max = greater(c,max);
        max = greater(d,max);
        max = greater(e,max);
        
        min = smaller(a,min);
        min = smaller(b,min);
        min = smaller(c,min);
        min = smaller(d,min);
        min = smaller(e,min);
        
        long sum = a + b + c + d + e;
        
        System.out.println((sum - max) + " " + (sum - min));
    }
}
