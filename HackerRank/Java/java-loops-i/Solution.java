import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-loops-i
public class Solution {

    public static final int noOfMulitples = 10;

    public static void main(String[] args) {
        /* read input */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        /* compute and print the restul to stdout */
        for (int i = 1; i <= noOfMulitples; i++)
            System.out.println(N + " x " + i + " = " + (N * i));
        
        /* close scanner */
        sc.close();
    }
}