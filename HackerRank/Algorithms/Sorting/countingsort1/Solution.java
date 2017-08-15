import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/countingsort1
public class Solution {

    public static void main(String[] args) {
        /* read input from STDIN using Scanner */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] count = new int[100];
        for (int i = 0; i < n; i++)
            /* increment the times the current number appears */
            count[in.nextInt()]++;
        
        for (int i = 0; i < n; i++) 
            System.out.print(count[i] + " ");
        
        /* close the scanner */
        in.close();
    }
}