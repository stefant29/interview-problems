import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/insertionsort2
public class Solution {
    
       // implementation of insertionSort
    public static void insertionSortPart2(int[] ar) {
        // if the array has only one element, the array is sorted, 
        // just print the array
        if (ar.length < 1) {
            printArray(ar);
            return;
        }
        // implementation of insertionSort
        for (int k = 1; k < ar.length; k++) {
            int val = ar[k];
            for (int i = 0; i < k; i++) {
                if (ar[i] > val) {
                    for (int j = k; j > i; j--) {
                        ar[j] = ar[j-1];
                    }
                    ar[i] = val;
                    break;
                }
            }
            printArray(ar);
        } 
    }
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
