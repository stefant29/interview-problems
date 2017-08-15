import java.util.*;

// https://www.hackerrank.com/challenges/quicksort1
public class Solution {
    static void partition(int[] ar) {
        /* if list is empty, there is nothing to be done */
        if (ar.length == 0)
            return;
        /* save the pivot */
        int pivot = ar[0];
        int len = ar.length;
        /*
         * use two aditional ArrayLists to copy the elements
         *   smaller and larger than the pivot
         */
        ArrayList<Integer> left = new ArrayList<Integer>();
        int equal = 1;
        ArrayList<Integer> right = new ArrayList<Integer>();
        /* 
         * iterate throught the array and add elements into left or right
         *   or increment the "equal" counter if the current element 
         *   is equal to the pivot
         */
        for (int i = 1; i < len; i++)
            if (ar[i] < pivot)
                left.add(ar[i]);
            else if (ar[i] > pivot)
                right.add(ar[i]);
            else
                equal++;

        /* print elements smaller than pivot */
        for (int i = 0; i < left.size(); i++)
            System.out.print(left.get(i) + " ");
        /* print the pivot a number of "equal" times */
        for (int i = 0; i < equal; i++)
            System.out.print(pivot + " ");
        /* print elements bigger than pivot */
        for (int i = 0; i < right.size(); i++)
            System.out.print(right.get(i) + " ");
    }
       
    public static void main(String[] args) {
        /* use a scanner to read the input from STDIN */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=in.nextInt(); 

        /* partition the array */
        partition(ar);
        
        /* close scanner */
        in.close();
    }    
}
