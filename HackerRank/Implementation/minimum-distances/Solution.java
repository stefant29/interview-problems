import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/minimum-distances
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            // key,    value
        int max_app = Integer.MIN_VALUE;
        for(int A_i=0; A_i < n; A_i++) {
            A[A_i] = in.nextInt();
            Integer count = map.get(A[A_i]);
            if (count == null)
                count = new Integer(0);
            map.put(A[A_i], (int)count + 1);
            if (count + 1 > max_app)
                max_app = count + 1;
        }
        System.out.println("ma: " + max_app);
        for (int i = 0; i < n; i++) {
            if ((int)map.get(A[i]) == max_app) {
                int first = i;
                int last = -1;
                while() {
                    
                }
            }           
        }
        System.out.println(map);
    }
}
