import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/minimum-distances
public class Solution {

    public static void main(String[] args) {
        // use scanner to read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        int max_app = Integer.MIN_VALUE;
        for(int A_i=0; A_i < n; A_i++)
            A[A_i] = in.nextInt();
        
        // find the minimum distance between two duplicates in the list
        int min_dist = Integer.MAX_VALUE;
        for(int i=0; i < n-1; i++) {
            // find min_distance for each element
            int current_dist = 0;
            for(int j=i+1; j < n; j++) {
                current_dist ++;
                if (A[i] == A[j]) {
                    // update the global minimum distance
                    if (current_dist < min_dist)
                        min_dist = current_dist;
                    break;
                }
            }
        }
        
        // if min_dist was not modified, then there are no duplicates
        //     in this case, print -1 to STDOUT
        if (min_dist == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(min_dist);
        
        // close scanner
        in.close();
    }
}
