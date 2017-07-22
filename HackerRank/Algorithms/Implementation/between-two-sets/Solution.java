import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/between-two-sets
public class Solution {

    static int getTotalX(int[] a, int[] b){
        Integer[] B = new Integer[b.length];
        for (int i = 0; i < b.length; i++)
            B[i] = b[i];
        Arrays.sort(B, Collections.reverseOrder());

        int count_x = 0;
        for (int i = 1; i <= B[0]; i++) {
            boolean to_continue = false;
            if (b[0] % i != 0) // does not divide B[0]
                continue;
            for (int j = 1; j < b.length; j++)
                if (b[j] % i != 0) {
                    to_continue = true;
                    break;
                }
            if (to_continue)
                continue;
            for (int i_a = 0; i_a < a.length; i_a++)
                if (i % a[i_a] != 0) {
                    to_continue = true;
                    break;
                }
            if (to_continue)
                continue;
            // if it reaches this point, then it's all good ;)
            count_x++;
        }
        return count_x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
    }
}
