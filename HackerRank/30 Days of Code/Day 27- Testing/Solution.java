import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-testing
public class Solution {

    /*
     * how Rand.nextInt() works: 
     * minimum + rn.nextInt(maxValue - minvalue + 1)
     */

    public static void main(String[] args) {
        Random r = new Random();

        int t = 1 + r.nextInt(5);
        System.out.println(t);
        int n = 3 + r.nextInt(198);
        HashSet<Integer> set = new HashSet<Integer>();
        for (int test = 0; test < t; test++) {
            while (set.contains(n)) {
                n = 3 + r.nextInt(198);
            }
            set.add(n);
            int k = 1 + r.nextInt(n);
            System.out.println(n + " " + k);
            for (int studTime = 0; studTime < n-3; studTime++) {
                int arrivalTime = r.nextInt(2001) - 1000;
                System.out.print(arrivalTime + " ");
            }
            System.out.print(r.nextInt(1001)-1000 + " ");
            System.out.print(r.nextInt(1001) + " ");
            System.out.println("0");
        }
    }
}

