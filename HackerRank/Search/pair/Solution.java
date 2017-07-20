import java.util.*;

// https://www.hackerrank.com/challenges/pairs
public class Solution {
    static int pairs(int[] a,int k) {
        // use aditional structure to store the sums needed
        HashSet<Integer> set = new HashSet<Integer>();

        // count the number of numbers that follow the condition
        int count = 0;
        // add the sum to the set
        for (int i = 0; i < a.length; i++)
            set.add(a[i] + k);
        
        // search if the sum exists in the set
        for (int i = 0; i < a.length; i++)
        	if (set.contains(a[i]))
        		count++;

        // return how many numbers respect the condition
        return count;
    }

    public static void main(String[] args) {
        // read input from stdin
        Scanner in = new Scanner(System.in);
        int res;
        int n = in.nextInt();
        int _k = in.nextInt();
        int[] _a = new int[n];
        for (int i = 0; i < n; i++)
            _a[i] = in.nextInt();
        
        res = pairs(_a,_k);
        // print result to STDOUT
        System.out.println(res);
        
        // close scanner
        in.close();
    }
}
