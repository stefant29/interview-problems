import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int getLevel(int n, int[] scores, int currentScore) {
        // extreme cases: first or last level
        if (currentScore < scores[n-1])
            return n + 1;
        else if (currentScore > scores[0])
            return 1;

        // binary search algo for finding the place in the leaderboard
        int lo = 0, hi = n-1, mid = -1;
        while (lo <= hi) {
            mid = lo + (hi-lo)/2;
            // compare with middle element
            if (scores[mid] == currentScore)
                return mid + 1;
            // if smaller, lower the high end
            else if (scores[mid] < currentScore) 
                hi = mid-1;
            // if bigger, advance the low end
            else
                lo = mid+1;
        }
        // return the current position
        return lo + 1;
    }

    public static void main(String[] args) {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        int actualDimension = 1;
        int lastElement = -1;
        scores[0] = in.nextInt();
        for(int scores_i=0; scores_i < n - 1; scores_i++){
            int currentElement = in.nextInt();
            // only if the element does not already exists
            if (scores[actualDimension-1] != currentElement) {
                // add the element to the array
                scores[actualDimension] = currentElement;
                // update the dimension of the array
                actualDimension++;
            }
        }
        
        // read the number of levels Alice is playing
        int m = in.nextInt();
        // for each level, compute the level she is currently on
        for(int i=0; i < m; i++) {
            int currentScore = in.nextInt();
            System.out.println(getLevel(actualDimension, scores, currentScore));
        }
    }
}