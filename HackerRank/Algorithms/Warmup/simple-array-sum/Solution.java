import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/simple-array-sum
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int sum = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            sum += in.nextInt();
        }
        System.out.println(sum);
    }
}
