import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/drawing-book
public class Solution {

    static int solve(int n, int p) {
        // extreme cases: first or last
        if (p == 1 || 
            (n % 2 == 0 && p == n) ||
            (n % 2 == 1 && (p == n || p == n - 1)))
            return 0;
        
        // if the last page is an even one
        if (n % 2 == 0)
            // add 1 to the last page to make it odd
            n++;
            
        // return the minimum
        return Math.min((n - p) / 2, p / 2);
    }

    public static void main(String[] args) {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        // output to STDOUT
        System.out.println(result);
    }
}
