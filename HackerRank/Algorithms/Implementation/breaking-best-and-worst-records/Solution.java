import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/breaking-best-and-worst-records
public class Solution {

    static int[] getRecord(int[] s){
        // Complete this function
        int high_score = s[0];
        int low_score = s[0];
        int[] score = new int[2];
        score[0] = score[1] = 0;
        for (int i : s) {
            if (i < low_score) {
                score[1]++;
                low_score = i;
            }
            if (i > high_score) {
                score[0]++;
                high_score = i;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}
