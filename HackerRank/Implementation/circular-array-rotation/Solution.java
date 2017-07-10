import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/circular-array-rotation
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            System.out.println(a[(n + (m - k % n)) % n]);
        }
    }
}

/*
// Self example
1 2 3             0: 1
3 1 2             1: 2
2 3 1             2: 
1 2 3
    
    k=3
    n=3
    m=2
(k + index) % n = m
*/