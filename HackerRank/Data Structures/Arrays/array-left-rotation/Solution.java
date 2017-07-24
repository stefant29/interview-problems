import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/array-left-rotation
public class Solution {

    public static void rotateLeft(int[] list, int d) {
        // if d is greater than n, do not rotate.
        // (move elements no more than n times)
        d = d % list.length;
        while(d > 0) {
            // keep the first element's value
            int val = list[0];
            // shift all elements to the left
            for (int i = 0; i < list.length-1; i++)
                list[i] = list[i+1];
            // update the last element with the value saved
            list[list.length-1] = val;
            d--;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++)
            list[i] = sc.nextInt();

        rotateLeft(list, d);

        for (int i : list)
            System.out.print(i + " ");
        
        in.close();
    }
}