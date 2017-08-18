import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/a-very-big-sum
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        long sum = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            //arr[arr_i] = in.nextInt();
           sum+=in.nextInt();
        }
        System.out.println(sum);
    }
}
