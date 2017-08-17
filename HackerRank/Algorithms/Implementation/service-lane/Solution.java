import java.util.*;

// https://www.hackerrank.com/challenges/service-lane
public class Solution {

    public static void main(String[] args) {
        /* read input */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int testCases = in.nextInt();
        int[] lanes = new int[N];
        for (int i = 0; i < N; i++)
            lanes[i] = in.nextInt();
        
        /* for each test case */
        for(int test = 0; test < testCases; test++) {
            /* read in and out points on the lane */
            int i = in.nextInt();
            int j = in.nextInt();
            int min = 3;
            /*
             * iterate through the lanes and find 
             * the smallest width: that is the solution
             */
            for (int k = i; k <= j; k++)
                if (lanes[k] < min)
                    min = lanes[k];
            
            /* print the solution */
            System.out.println(min);
        }
        /* close scanner */
        in.close();
    }
}