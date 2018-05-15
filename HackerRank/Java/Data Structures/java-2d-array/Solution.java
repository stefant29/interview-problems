import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-2d-array
public class Solution {

    public static int sum_hourGlass(int[][] mat, int i, int j) {
        return mat[i][j] + mat[i][j+1] + mat[i][j+2] + 
                           mat[i+1][j+1] + 
               mat[i+2][j] + mat[i+2][j+1] + mat[i+2][j+2];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
                int crtSum = sum_hourGlass(arr, i, j);
                if (crtSum > maxSum)
                    maxSum = crtSum;
            }
        }
        System.out.println(maxSum);
    }
}
