import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/tutorial-intro
public class Solution {

    public static void main(String[] args) {
        // use Scanner to read from STDIN
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int n = in.nextInt();

        // there is no need to use aditional structures
        //    to store the array
        //int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            // just read the numbers and check if they equal to V
            if (V == in.nextInt()) {
                // print the index to STDOUT
                System.out.println(i);
                // and break the loop
                break;
            }
        }
        
        // close the scanner
        in.close();
    }
}