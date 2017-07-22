import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/climbing-the-leaderboard
public class Solution {

    public static void main(String[] args) {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // store the score in a linkedList (dynamically allocated for
        //  a random number of elements: the number of elements is
        //  smaller or equal to n because i don't store duplicates)
        LinkedList<Integer> scores = new LinkedList<Integer>();
        int lastElement = -1;
        for(int scores_i=0; scores_i < n; scores_i++){
            int currentElement = in.nextInt();
            // only if the element does not already exists
            if (lastElement != currentElement) {
                // add the element to the linkedlist
                scores.addFirst(currentElement);
                lastElement = currentElement;
            }
        }
        
        // read the number of levels Alice is playing
        int m = in.nextInt();
        for(int i=0; i < m; i++){
            int currentScore = in.nextInt();
            // if the current score is bigger than the first players's
            // score, than Alice is at the top of the ladder
            if (currentScore >= (int)scores.getLast()) {
                System.out.println("1");
                continue;
            }
            
            // check the current level Alice is on
            for (int j = 0; j < scores.size(); j++) {
                if (currentScore < (int)scores.get(j)) {
                    System.out.println(scores.size() - j + 1);
                    break;
                }
            }
        }
    }
}
