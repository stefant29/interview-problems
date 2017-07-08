import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/permutation-equation
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }
        for (int x = 1; x <= n; x++) {
            int i = 0;
            for (; i < n; i++) {
                if (p[i] == x)
                    break;
            }
            i++;
            int j = 0;
            for (; j < n; j++) {
                if (p[j] == i)
                    break;
            }
            
            if (j < n)
                System.out.println(j+1);
        }
    }
}
