import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/beautiful-triplets
public class Solution {

    public static void main(String[] args) {
        // read input from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        // itterate throught the array and find the numbers that match
        //     the condition for beautiful triplets
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (a[j] > a[i] + d)
                    break;
                else if (a[j] != a[i] + d)
                    continue;
                for (int k = 0; k < n; k++) {
                    if (a[k] > a[j] + d)
                        break;
                    else if (a[k] != a[j] + d)
                        continue;
                    else if (a[k] == a[j] + d) {
                        count++;
                        break;
                    }
                }
            }
        }
        
        // write to STDOUT the number of beautiful triplets in the array
        System.out.println(count);
        
        // close the scanner
        in.close();
    }
}