import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/taum-and-bday
public class Solution {

    public static void main(String[] args) {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();
            
            // compute the price nedded for conversion
            long b_convertedFromW = y + z;
            long w_convertedFromB = x + z;
            
            // compute the total sum needed for each present: W & B
            long sumB = b * (Math.min(x, b_convertedFromW));
            long sumW = w * (Math.min(y, w_convertedFromB));
            
            // print at STDOUT
            System.out.println(sumB + sumW);
        }
        // close the scanner
        in.close();
    }
}
