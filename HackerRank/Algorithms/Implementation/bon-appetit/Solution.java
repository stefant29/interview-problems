import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/bon-appetit
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] cost = new int[n];
        int b_total = 0;
        for (int i = 0; i < n; i++) {
            cost[i] = in.nextInt();
            b_total += cost[i];
        }
        int b_charged = in.nextInt();
        int sol = b_charged - (b_total - cost[k]) / 2;
        if (sol == 0)
            System.out.println("Bon Appetit");
        else 
            System.out.println(sol);
        
        
    }
}
