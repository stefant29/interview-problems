import java.util.*;

// https://www.hackerrank.com/challenges/lilys-homework
public class Solution {
   
    public static int sort(int[] arr) {
        int noSwaps = 0;
        int len = arr.length;
        
        //      key=value   value=index
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] sorted = new int[len];
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
            sorted[i] = arr[i];
        }
        
        /* sort the copy array */
        Arrays.sort(sorted);
        
        for (int i = 0; i < len; i++) {
            /* compare the original array with its copy*/
        	if (sorted[i] != arr[i]) {
                /* if not equal, make a swap */
	        	int index = map.get(sorted[i]);
	        	int aux = arr[i];
                /* and update the map */
	        	map.replace(arr[i], index);
	        	arr[i] = sorted[i];
	        	arr[index] = aux;
                /* and the counter for number of swaps */
	        	noSwaps++;
        	}
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
        int[] revArr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
            revArr[N-i-1] = arr[i];
        }

        /* 
         * find the minimum difference by sorting both 
         * increasingly and decreasingly
         */
        System.out.println(Math.min(sort(arr), sort(revArr)));
        
        /* close scanner */
        in.close();
    }
}