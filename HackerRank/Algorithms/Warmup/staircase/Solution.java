import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/staircase
public class Solution {

    public static void main(String[] args) {
        /* read input from STDIN */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        /* draw the staircase */
        for (int i = 1; i <= n; ++i) {
            int j = n;
            while (j > i) {
                System.out.print(" ");
                --j;
            }
            int k = i;
            while (k > 0) {
                System.out.print("#");
                --k;
            }    
            System.out.println();
        }

        /* close scanner */
        in.close();
    }
}
