import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/lilys-homework
public class Solution {
   
    public static int findMinimum (int[] arr, int index) {
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        if (len == 0)
            return -1;
        for (int i = index; i < len; i++) {
            if (min >  arr[i]) {
                minIndex = i;
                min = arr[i];
            }
        }
        return minIndex;
    }
    
    public static int sort(int[] arr) {
        int noSwaps = 0;
        int len = arr.length;
        
        for (int i = 0; i < len; i++) {
            int minIndex = findMinimum(arr, i);
            if (i != minIndex) {
                noSwaps++;
                int aux = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = aux;
            }
            //printArray(arr);
        }
        
        return noSwaps;
    }

    public static void printArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
       /* read input */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = in.nextInt();
        
        System.out.println(sort(arr));
        
        /* close scanner */
        in.close();
    }
}