import java.io.*;
import java.util.*;

//https://www.hackerrank.com/challenges/beautiful-days-at-the-movies
public class Solution {

    public static long rev(long n) {
        long rev = 0;
        //System.out.print("n: " + n);
        while (n > 0) {
            //if (n % 10 != 0)
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        //System.out.println("    rev: " + rev);
        return rev;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long i = in.nextLong();
        long j = in.nextLong();
        long k = in.nextLong();
        int beautiful_days = 0;
        for (long x = i; x <= j; x++) {
            if (Math.abs(x - rev(x)) % k == 0) {
                beautiful_days++;
            }
        }
        System.out.println(beautiful_days);
    }
}