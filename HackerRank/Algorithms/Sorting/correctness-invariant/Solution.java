import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/correctness-invariant
public class Solution {

    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            // move the elements to the right until A[j] reaches
            // its places in the sorted array
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }
            // instert the value at the good position in the array
            A[j + 1] = value;
        }

        // print the sorted array
        printArray(A);
    }

    // print the array at STDOUT
    static void printArray(int[] ar) {
        for(int n: ar)
            System.out.print(n+" ");
    }

    public static void main(String[] args) {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=in.nextInt();

        // sort the array using Insertion Sort
        insertionSort(ar);

        // close the scanner
        in.close();
    }
}
